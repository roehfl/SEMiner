package com.sol.seminer.service;

import com.sol.seminer.config.Properties;
import com.sol.seminer.dto.GoogleSearchResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

public class SEServiceImpl implements SEMinerService{

    private final Properties properties;
    private final WebClient webClient;

    public SEServiceImpl(Properties properties, WebClient.Builder webClientBuilder) {
        this.properties = properties;
        this.webClient = webClientBuilder.baseUrl("https://www.googleapis.com").build();
    }

    @Override
    public List<Object> search(String engineName, String keyword) {
        if (engineName.equals("google")) {
            String apiKey = properties.getGoogle().getApiKey();
            String cx = properties.getGoogle().getCx();
            String url = properties.getGoogle().getUrl() + keyword + "&key=" + apiKey + "&cx=" + cx;
            webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(GoogleSearchResponse.class)  // JSON -> DTO 변환
                    .map(response -> response.getItems().stream()
                            .map(GoogleSearchResponse.GoogleSearchItem::getLink)
                            .collect(Collectors.toList())
                    );
        } else {
            return null;
        }
    }
}
