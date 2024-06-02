package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Order;
import com.example.model.User;

public class DashboardController {
    public User getUser() {
        // Fetch the user information
        return new User("John", "Doe", null, null, null, null);
    }

    public List<Order> getActiveOrders() {
        // Fetch active orders
        List<Order> orders = new ArrayList<>();
        // Sample order data
        // orders.add(new Order());
        return orders;
    }
}

