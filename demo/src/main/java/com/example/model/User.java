
package com.example.model;


import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private List<Order> activeOrders;
    private boolean isVIP;
    private int credits;

    // Constructor
    public User(String firstName, String lastName, String username, String password, String email, List<Order> activeOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.activeOrders = activeOrders;
        this.isVIP = false;
        this.email = "";
        this.credits = 0;
    }

   
    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void upgradeToVIP(String email) {
        this.isVIP = true;
        this.email = email;
    }
    public List<Order> getActiveOrders() {
        return activeOrders;
    }
}
