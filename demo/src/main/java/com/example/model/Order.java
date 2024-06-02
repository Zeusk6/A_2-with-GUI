package com.example.model;

// import java.util.List;

// public class Order {
//     private int orderNumber;
//     private List<String> foodItems;
//     private double totalPrice;
//     private String orderStatus;

//     // Getters and setters
//     public int getOrderNumber() { return orderNumber; }
//     public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }

//     public List<String> getFoodItems() { return foodItems; }
//     public void setFoodItems(List<String> foodItems) { this.foodItems = foodItems; }

//     public double getTotalPrice() { return totalPrice; }
//     public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

//     public String getOrderStatus() { return orderStatus; }
//     public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
//     public OrderItem[] getItems() {
//         OrderItem[] a={};
//         return a;
       
//     }
// }
import java.time.LocalDateTime;

public class Order {
    private String orderNumber;
    private LocalDateTime orderTime;
    private double totalPrice;
    private String status;

    public Order(String orderNumber, LocalDateTime orderTime, double totalPrice, String status) {
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
