package com.sol.seminer.handler;

import com.sol.seminer.dto.GoogleSearchResponse;
import com.sol.seminer.service.SEMinerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class SEMinerHandler {
    private final SEMinerService service;

    public SEMinerHandler(SEMinerService service) {
        this.service = service;
    }

    public Mono<ServerResponse> test(ServerRequest request) {
        String keyword = request.queryParam("keyword").orElse("");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(service.search("google", keyword), GoogleSearchResponse.class);
    }
}
