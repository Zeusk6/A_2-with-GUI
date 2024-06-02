package com.example.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BasketItem {
    private final SimpleStringProperty itemName;
    private final SimpleIntegerProperty quantity;
    private final SimpleDoubleProperty price;

    public BasketItem(String itemName, int quantity, double price) {
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getItemName() {
        return itemName.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public double getPrice() {
        return price.get() * getQuantity();
    }
}
