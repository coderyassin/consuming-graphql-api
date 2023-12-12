package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.MyGraphQLService;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("graphQL")
public class MyGraphQLController {

    private final MyGraphQLService myGraphQLService;

    public MyGraphQLController(MyGraphQLService myGraphQLService) {
        this.myGraphQLService = myGraphQLService;
    }

    @GetMapping(value = "products")
    public List<Product> consumeGraphQLRequest() {
        return myGraphQLService.productList();
    }

    @GetMapping(value = "/productById/{id}")
    public Mono<Product> productById(@PathVariable String id) {
        return myGraphQLService.productById(id);
    }
}
