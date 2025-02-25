package com.sol.seminer.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


public interface SEMinerService {
    Flux search(String engineName, String keyword);
}
