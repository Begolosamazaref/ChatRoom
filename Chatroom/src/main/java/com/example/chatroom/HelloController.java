package com.example.chatroom;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button Login;

    @FXML
    private Button SignUp;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    @FXML
    private ImageView userIcon, passwordIcon;

    @FXML
    private Label Error;

    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Username.getText().isBlank() || Password.getText().isBlank()) {
                    // Handle blank fields
                    Error.setText("Username and Password are required");
                    Error.setStyle(errorStyle);
                    new animatefx.animation.Shake(Username).play();
                    new animatefx.animation.Wobble(userIcon).play();
                    new animatefx.animation.Shake(Password).play();
                    new animatefx.animation.Wobble(passwordIcon).play();
                } else {
                    // Send login request to server
                    try {
                        String Operation = "Login." + Username.getText() + "." + Password.getText();
                        new Clinte(Operation);

                        // Wait for response from server
                        Thread.sleep(1000);

                        // Check if login operation was successful
                        if (Clinte.Operation.equals("Success")) {
                            Error.setText("Login Successful");
                            Error.setStyle(successMessage);
                            Username.setStyle(successStyle);
                            Password.setStyle(successStyle);

                            DBUtils.ChangeScene(event, "Chatroom.fxml", "Chat Room");
                            Clinte.Operation = "Failed";
                        } else {
                            Username.setStyle(errorStyle);
                            Password.setStyle(errorStyle);
                            new animatefx.animation.Shake(Username).play();
                            new animatefx.animation.Wobble(userIcon).play();
                            new animatefx.animation.Shake(Password).play();
                            new animatefx.animation.Wobble(passwordIcon).play();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Error.setText("An error occurred. Please try again later.");
                        Error.setStyle(errorStyle);
                    }
                }
            }
        });

        SignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.ChangeScene(event, "SignUp.fxml", "Sign up");
            }
        });


    }

}