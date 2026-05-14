package com.example.orderservice.dto;
import lombok.Data;
@Data
public class FoodDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
}
