package com.example.orderservice.service;
import com.example.orderservice.dto.FoodDTO;
import com.example.orderservice.dto.UserDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Order createOrder(Order order) {
        UserDTO user = restTemplate.getForObject(
                "http://localhost:8081/users/" + order.getUserId(),
                UserDTO.class
        );
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        FoodDTO food = restTemplate.getForObject(
                "http://localhost:8082/foods/" + order.getFoodId(),
                FoodDTO.class
        );
        if (food == null) {
            throw new RuntimeException("Food not found");
        }
        order.setTotalPrice(food.getPrice() * order.getQuantity());
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
}