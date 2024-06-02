package com.example.model;



import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public boolean registerUser(String username, String password, String firstName, String lastName) {
        if (users.containsKey(username)) {
            return false;
        }
        User newUser = new User(username, password, firstName, lastName, lastName, null);
        users.put(username, newUser);
        return true;
    }

    public User loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static void editProfile(User user, String firstName, String lastName, String password) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
    }

    public static void upgradeToVIP(User user, String email) {
        user.upgradeToVIP(email);
    }
}
