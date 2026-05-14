package com.example.foodservice.controller;
import com.example.foodservice.entity.Food;
import com.example.foodservice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/foods")
@CrossOrigin("*")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @GetMapping

    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }
    @PostMapping
    public Food addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }
    @PutMapping("/{id}")
    public Food updateFood(@PathVariable Long id,
                           @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }
}
