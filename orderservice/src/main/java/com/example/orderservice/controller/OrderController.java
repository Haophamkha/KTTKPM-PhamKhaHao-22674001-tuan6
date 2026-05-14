package com.example.orderservice.controller;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
                              @RequestBody Map<String, String> body) {
        return orderService.updateStatus(id,
                body.get("status"));
    }
}