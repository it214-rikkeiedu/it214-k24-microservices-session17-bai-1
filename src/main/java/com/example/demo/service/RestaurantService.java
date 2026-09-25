package com.example.demo.service;

import com.example.demo.model.Restaurant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Cacheable(value = "restaurants", key = "#restaurantId")
    public Restaurant getRestaurantById(Long restaurantId) {
        // Simulate slow database call
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Restaurant(restaurantId, "GrabFood District 1");
    }
}