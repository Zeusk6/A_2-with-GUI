
package com.example.view;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginView extends GridPane {
    private TextField userTextField;
    private PasswordField pwBox;
    private Button loginBtn;
    private Button registerBtn;

    public LoginView() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("User Name:");
        this.add(userName, 0, 1);

        userTextField = new TextField();
        this.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        this.add(pw, 0, 2);

        pwBox = new PasswordField();
        this.add(pwBox, 1, 2);

        loginBtn = new Button("Login");
        this.add(loginBtn, 1, 4);

        registerBtn = new Button("Register");
        this.add(registerBtn, 1, 5);
    }

    public String getUserName() {
        return userTextField.getText();
    }

    public String getPassword() {
        return pwBox.getText();
    }

    public void setLoginAction(Runnable action) {
        loginBtn.setOnAction(e -> action.run());
    }

    public void setSignupAction(Runnable action) {
        registerBtn.setOnAction(e -> action.run());
    }
}



