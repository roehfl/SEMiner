package com.sol.seminer.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SEMinerService {
    List<Object> search(String engineName, String keyword);
}
