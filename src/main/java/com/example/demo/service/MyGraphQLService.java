package com.example.demo.service;

import com.example.demo.model.Product;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MyGraphQLService {

    List<Product> productList();
    Mono<Product> productById(String id);

}
