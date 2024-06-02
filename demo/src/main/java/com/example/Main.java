package com.example;

import com.example.controller.LoginController;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    // private DashboardView dashboardView = new DashboardView();

    @Override
    public void start(Stage primaryStage) {
        LoginController loginController = new LoginController(primaryStage);

    }
    //  @Override
    // public void start(Stage primaryStage) {
    //     // LoginController loginController = new LoginController(primaryStage);
    //     primaryStage.setTitle("Dashboard");

    //     // Show the DashboardView in the main window
    //     StackPane root = new StackPane();
    //     root.getChildren().add(dashboardView);

    //     Scene scene = new Scene(root, 800, 600);
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    // }

    public static void main(String[] args) {
        launch(args);
    }
}
