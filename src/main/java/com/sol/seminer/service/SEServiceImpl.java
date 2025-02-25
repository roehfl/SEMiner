package com.sol.seminer.service;

import com.sol.seminer.config.Properties;
import com.sol.seminer.dto.GoogleSearchItem;
import com.sol.seminer.dto.GoogleSearchResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SEServiceImpl implements SEMinerService{

    private final Properties properties;
    private final WebClient webClient;

    public SEServiceImpl(Properties properties, WebClient.Builder webClientBuilder) {
        this.properties = properties;
        this.webClient = webClientBuilder.baseUrl("https://www.googleapis.com").build();
    }

    @Override
    public Flux search(String engineName, String keyword) {
        if (engineName.equals("google")) {
            String apiKey = properties.getGoogle().getApiKey();
            String cx = properties.getGoogle().getCx();
            String url = properties.getGoogle().getUrl() + keyword + "&key=" + apiKey + "&cx=" + cx;
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(GoogleSearchResponse.class)  // JSON -> DTO 변환
                    .map(response -> response.getItems().stream()
                            .map(GoogleSearchItem::getLink)
                            .collect(Collectors.toList())
                    );
        } else {
            return null;
        }
    }
}
