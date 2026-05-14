package com.example.paymentservice.controller;
import com.example.paymentservice.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;
    @PostMapping
    public String payment(@RequestBody PaymentRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("status", "PAID");
        restTemplate.put(
                "http://order-service:8083/orders/"
                        + request.getOrderId()
                        + "/status",
                body
        );
        System.out.println(
                "Notification: Order #"
                        + request.getOrderId()
                        + " payment success"
        );
        return "Payment success";
    }
}
