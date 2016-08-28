package com.spaniard.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Nesterov
 * @version 1.0
 */
@Getter
@Setter
@Component
@ConfigurationProperties("kafkaListenerConfig")
public class KafkaListenerProperties {

    private Integer concurrency;
    private Integer pollTimeout;
}
