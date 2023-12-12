package com.example.demo.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {

    private String name;
    private double price;
    private int quantity;

}
