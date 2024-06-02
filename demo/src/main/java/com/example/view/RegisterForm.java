package com.example.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the registration form
        Label userLabel = new Label("First Name");
        TextField userTextField = new TextField();
        
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        
        Button registerButton = new Button("Register");

        // Layout for the registration form
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(userLabel, 0, 0);
        gridPane.add(userTextField, 1, 0);
        gridPane.add(passLabel, 0, 1);
        gridPane.add(passField, 1, 1);
        gridPane.add(registerButton, 1, 2);

        Scene registerScene = new Scene(gridPane, 300, 200);

        // Handle button action to navigate to a new scene
        registerButton.setOnAction(event -> {
            Label welcomeLabel = new Label("Welcome, " + userTextField.getText() + "!");
            VBox welcomeLayout = new VBox(20, welcomeLabel);
            Scene welcomeScene = new Scene(welcomeLayout, 300, 200);
            primaryStage.setScene(welcomeScene);
        });

        primaryStage.setTitle("Register Form");
        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
