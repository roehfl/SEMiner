package com.sol.seminer.config;

import com.sol.seminer.handler.SEMinerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> userRoutes(SEMinerHandler seMinerHandler) {
        return RouterFunctions.route()
                .GET("/test", seMinerHandler::test)
                .build();
    }
}