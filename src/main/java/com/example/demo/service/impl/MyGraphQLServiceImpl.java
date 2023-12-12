package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.service.MyGraphQLService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Properties;

@Service
public class MyGraphQLServiceImpl implements MyGraphQLService {
    private Properties properties;
    @Value("${graphqlEndpoint}")
    private String graphqlEndpoint;
    private WebClient wc;
    private GraphQlClient client;

    public MyGraphQLServiceImpl(@Qualifier("queriesProperties") Properties properties) {
        this.properties = properties;
    }

    @PostConstruct
    private void init() {
        wc  = WebClient.create(graphqlEndpoint);
        client = HttpGraphQlClient.create(wc);
    }

    @Override
    public List<Product> productList() {
        String graphqlQuery = properties.get("productDetails").toString();
        return client.document(graphqlQuery)
                .retrieve("productList")
                .toEntityList(Product.class)
                .block();
    }

    @Override
    public Mono<Product> productById(String id) {
        String graphqlQuery = properties.get("productById").toString();
        return client.document(graphqlQuery)
                .variable("id", id)
                .retrieve("productById")
                .toEntity(Product.class);
    }
}
