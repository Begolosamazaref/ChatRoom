package com.example.chatroom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField confirmpassword;
    @FXML
    private Button cancel;
    @FXML
    private Button signup;
    @FXML
    private Button back;

    @FXML
    private Label Error;

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().isBlank() || password.getText().isBlank() || confirmpassword.getText().isBlank()) {
                    // Handle blank fields
                } else if (password.getText().length() < 8) {
                    // Handle password length less than 8 characters
                    Error.setText("Password should be at least 8 characters long.");
                    username.setStyle(successStyle);
                    password.setStyle(errorStyle);
                    confirmpassword.setStyle(successStyle);
                    new animatefx.animation.Shake(password).play();
                } else if (!password.getText().equals(confirmpassword.getText())) {
                    // Handle password and confirm password mismatch
                    Error.setText("Passwords do not match.");
                    username.setStyle(successStyle);
                    password.setStyle(errorStyle);
                    confirmpassword.setStyle(errorStyle);
                    new animatefx.animation.Shake(password).play();
                    new animatefx.animation.Shake(confirmpassword).play();
                } else {
                    // Perform sign up operation
                    String Operation = "SignUp." + username.getText() + "." + password.getText();
                    new Clinte(Operation);

                    // Handle sign up success
                    Error.setText("Sign up Successful");
                    Error.setStyle(successMessage);
                    username.setStyle(successStyle);
                    password.setStyle(successStyle);
                    confirmpassword.setStyle(successStyle);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    DBUtils.ChangeScene(event, "hello-view.fxml", "Welcome");
                }
            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ChangeScene(event, "SignUp.fxml", "SignUp");
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ChangeScene(event, "hello-view.fxml", "Welcome");
            }
        });
    }
}