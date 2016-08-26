package com.spaniard;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

/**
 * @author Alexander Nesterov
 * @version 1.0
 */
@EnableKafka
@Configuration
@EnableConfigurationProperties
public class KafkaConfiguration {

    @Autowired
    ApplicationProperties applicationProperties;

    @Bean
    Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(BOOTSTRAP_SERVERS_CONFIG, applicationProperties.getBootstrapServers());
        props.put(GROUP_ID_CONFIG, applicationProperties.getGroupId());
        props.put(ENABLE_AUTO_COMMIT_CONFIG, applicationProperties.getEnableAutoCommit());
        props.put(AUTO_COMMIT_INTERVAL_MS_CONFIG, applicationProperties.getAutoCommitIntervalMs());
        props.put(SESSION_TIMEOUT_MS_CONFIG, applicationProperties.getSessionTimeoutMs());
        props.put(KEY_DESERIALIZER_CLASS_CONFIG, applicationProperties.getKeyDeserializer());
        props.put(VALUE_DESERIALIZER_CLASS_CONFIG, applicationProperties.getValueDeserializer());
        return props;
    }

    @Bean
    ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    @Bean
    CarListener carListener() {
        return new CarListener();
    }
}
