package com.sol.seminer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleSearchResponse {
    private List<GoogleSearchItem> items;

}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class GoogleSearchItem {
    private String title;
    private String link;
}
