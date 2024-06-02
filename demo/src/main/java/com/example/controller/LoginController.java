package com.example.controller;

// import com.example.view.DashboardView;
import com.example.view.LoginView;
import com.example.view.MainView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    private LoginView view;
    private Stage stage;
    // private DashboardView dashboardView = new DashboardView();

    public LoginController(Stage stage) {
        this.stage = stage;
        this.view = new LoginView();

        // Set actions for buttons
        view.setLoginAction(this::handleLogin);
        view.setSignupAction(this::handleSignup);

        // Set the view in the stage
        stage.setScene(new Scene(view, 400, 300));
        stage.setTitle("Login");
        stage.show();
    }

    private void handleLogin() {
        // Implement your login logic here
        String userName = view.getUserName();
        String password = view.getPassword();
        System.out.println("Login button pressed with username: " + userName + " and password: " + password);
         stage.setTitle("Dashboard");

        // // Show the DashboardView in the main window
        // StackPane root = new StackPane();
        // root.getChildren().add(dashboardView);

        // Scene scene = new Scene(root, 800, 600);
        // stage.setScene(scene);
        // stage.show();
          MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);

        mainView.start(stage, mainController.getBasketItems());
        mainController.initialize();
    }

    private void handleSignup() {
        // Switch to signup scene
        SignupController signupController = new SignupController(stage);
    }
    
}
