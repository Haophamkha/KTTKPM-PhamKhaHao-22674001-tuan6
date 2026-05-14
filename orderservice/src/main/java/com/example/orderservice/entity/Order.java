package com.example.orderservice.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long foodId;
    private int quantity;
    private double totalPrice;
    private String status;
}
