package com.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SignupView extends GridPane {
    private TextField userTextField;
    private PasswordField pwBox;
    private PasswordField confirmPwBox;
    private Button signupBtn;
    private Button loginBtn;

    public SignupView() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));


        Label firstName = new Label("First Name:");
        this.add(firstName, 0, 1);

        userTextField = new TextField();
        this.add(userTextField, 1, 1);

        Label lastName = new Label("Last Name:");
        this.add(lastName, 0, 2);

        userTextField = new TextField();
        this.add(userTextField, 1, 2);

        Label userName = new Label("User Name:");
        this.add(userName, 0, 3);

        userTextField = new TextField();
        this.add(userTextField, 1, 3);

        Label pw = new Label("Password:");
        this.add(pw, 0, 4);

        pwBox = new PasswordField();
        this.add(pwBox, 1, 4);

        // Label confirmPw = new Label("Confirm Password:");
        // this.add(confirmPw, 0, 5);

        // confirmPwBox = new PasswordField();
        // this.add(confirmPwBox, 1, 5);

        signupBtn = new Button("Signup");
        this.add(signupBtn, 1, 5);

        loginBtn = new Button("Back to Login");
        this.add(loginBtn, 1, 6);
    }

    public String getUserName() {
        return userTextField.getText();
    }

    public String getPassword() {
        return pwBox.getText();
    }

    public String getConfirmPassword() {
        return confirmPwBox.getText();
    }



    public void setSignupAction(Runnable action) {
        signupBtn.setOnAction(e -> action.run());
    }

    public void setLoginAction(Runnable action) {
        loginBtn.setOnAction(e -> action.run());
    }

    public String getFirstName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }

    public String getlastName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getlastName'");
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
