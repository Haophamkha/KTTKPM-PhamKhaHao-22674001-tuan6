package com.example.foodservice.config;
import com.example.foodservice.entity.Food;
import com.example.foodservice.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadData(FoodRepository repository) {
        return args -> {
            repository.save(new Food(null,
                    "Hamburger",
                    50000,
                    "Burger bò"));
            repository.save(new Food(null,
                    "Pizza",
                    120000,
                    "Pizza hải sản"));
            repository.save(new Food(null,
                    "Fried Chicken",
                    80000,
                    "Gà rán giòn"));
        };
    }
}