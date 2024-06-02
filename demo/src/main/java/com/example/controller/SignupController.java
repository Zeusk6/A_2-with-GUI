package com.example.controller;

import com.example.model.User;
import com.example.model.UserService;
import com.example.view.SignupView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignupController {
    private SignupView view;
    private Stage stage;

    public SignupController(Stage stage) {
        this.stage = stage;
        this.view = new SignupView();

        // Set actions for buttons
        view.setSignupAction(this::handleSignup);
        view.setLoginAction(this::handleLogin);

        // Set the view in the stage
        stage.setScene(new Scene(view, 400, 300));
        stage.setTitle("Signup");
        stage.show();
    }

    private void handleSignup() {
        // Implement your signup logic here
        String userName = view.getUserName();
        String password = view.getPassword();
     
        String firstName = view.getFirstName();
     
        String lastName = view.getlastName();
       
        System.out.println("Signup button pressed with username: " + userName + ", password: " + password  );

    }

    private void handleLogin() {
        // Switch back to login scene
        
        LoginController loginController = new LoginController(stage);
    }
       public void editProfile(User user) {
        System.out.print("Enter new first name: ");
        String firstName = view.getFirstName();
        System.out.print("Enter new last name: ");
        String lastName = view.getlastName();
        System.out.print("Enter new password: ");
        String password = view.getPassword();

        UserService.editProfile(user, firstName, lastName, password);
        System.out.println("Profile updated successfully.");
    }

    public void upgradeToVIP(User user) {
        System.out.print("Enter email: ");
        String email = view.getEmail();
        UserService.upgradeToVIP(user, email);
        System.out.println("Upgraded to VIP successfully.");
    }
}
