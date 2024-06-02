package com.example.controller;

import java.time.LocalDateTime;
import java.util.Random;

import com.example.model.BasketItem;
import com.example.model.MenuItem;
import com.example.model.Order;
import com.example.view.MainView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainController {
    private ObservableList<BasketItem> basketItems;
    private MainView mainView;
    private ObservableList<Order> allOrders;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        basketItems = FXCollections.observableArrayList();
    }

    public void initialize() {
        // Sample menu items
        MenuItem burritos = new MenuItem("Burritos", 20.0, "file:/controller/burritos2.jpg");
        MenuItem fries = new MenuItem("Fries", 11.5, "file:/path/to/fries.jpg");
        MenuItem soda = new MenuItem("Soda", 5.0, "file:/path/to/soda.jpg");

        // Add menu items to the view
        mainView.addMenuItemToGrid(burritos, 0, () -> addItemToBasket(burritos, 1));
        mainView.addMenuItemToGrid(fries, 1, () -> addItemToBasket(fries, 1));
        mainView.addMenuItemToGrid(soda, 2, () -> addItemToBasket(soda, 1));

        mainView.getPlaceOrderButton().setOnAction(e -> showOrderSummary());
    }

    private void addItemToBasket(MenuItem menuItem, int quantity) {
        boolean found = false;
        for (BasketItem item : basketItems) {
            if (item.getItemName().equals(menuItem.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            basketItems.add(new BasketItem(menuItem.getName(), quantity, menuItem.getPrice()));
        }
    }

    // private void placeOrder() {
    //     // Handle order placement (e.g., save to database, show confirmation)
    //     System.out.println("Order placed!");
    // }

    // public ObservableList<BasketItem> getBasketItems() {
    //     return basketItems;
    // }
    private void showOrderSummary() {
        double totalPrice = basketItems.stream().mapToDouble(BasketItem::getPrice).sum();
        int waitingTime = new Random().nextInt(30) + 10; // Random waiting time between 10 and 40 minutes
        mainView.showOrderSummary(totalPrice, waitingTime, this::proceedToPayment);
    }

    private void proceedToPayment() {
        mainView.showPaymentForm(this::completeOrder);
    }

    // private void completeOrder() {
    //     String orderNumber = generateOrderNumber();
    //     System.out.println("Order placed successfully. Order Number: " + orderNumber);
    //     // Reset basket items after placing the order
    //     basketItems.clear();
    // }

       private void completeOrder() {
        String orderNumber = generateOrderNumber();
        LocalDateTime orderTime = LocalDateTime.now();
        double totalPrice = basketItems.stream().mapToDouble(BasketItem::getPrice).sum();
        Order order = new Order(orderNumber, orderTime, totalPrice, "await for collection");
        allOrders.add(0, order); // Add to the beginning for reverse chronological order

        System.out.println("Order placed successfully. Order Number: " + orderNumber);
        // Reset basket items after placing the order
        basketItems.clear();
    }
    private String generateOrderNumber() {
        return "ORD" + LocalDateTime.now().getNano();
    }

    public ObservableList<BasketItem> getBasketItems() {
        return basketItems;
    }
  
    public ObservableList<Order> getAllOrders() {
        // Generate some random orders for demonstration purposes\    
        if (allOrders == null) {
            allOrders = FXCollections.observableArrayList(); // Initialize allOrders if it's null
        }
        Random random = new Random();
        int numOrders = random.nextInt(10) + 1; // Generate between 1 and 10 orders
        ObservableList<Order> randomOrders = FXCollections.observableArrayList();
        for (int i = 0; i < numOrders; i++) {
            // Generate random order details (for demonstration, you would have your own logic here)
            String orderId = "Order" + (i + 1);
            double amount = random.nextDouble() * 1000; // Random amount between 0 and 1000
            Order order = new Order(orderId, null, amount, orderId); // Assuming Order constructor takes orderId and amount
            randomOrders.add(order);
        }
        return randomOrders;
    }
}
