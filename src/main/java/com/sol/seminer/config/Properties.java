package com.sol.seminer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "properties")
public class Properties {
    private Engine google;

    @Data
    public static class Engine {
        private String url;
        private String apiKey;
        private String cx;
    }
}
