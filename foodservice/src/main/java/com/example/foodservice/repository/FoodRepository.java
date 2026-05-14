package com.example.foodservice.repository;
import com.example.foodservice.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FoodRepository extends JpaRepository<Food, Long> {
}
