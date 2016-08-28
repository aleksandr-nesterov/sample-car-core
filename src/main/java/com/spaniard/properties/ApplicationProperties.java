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
@ConfigurationProperties("configuration")
public class ApplicationProperties {

    private String bootstrapServers;
    private String groupId;
    private Boolean enableAutoCommit;
    private Integer autoCommitIntervalMs;
    private Integer sessionTimeoutMs;
    private String keyDeserializer;
    private String valueDeserializer;
}
