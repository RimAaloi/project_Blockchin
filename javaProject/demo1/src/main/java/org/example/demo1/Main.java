package org.example.demo1;

//package com.example.inventory;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/demo1/main.fxml")
        );

        Parent root = loader.load(); // Load the FXML content

        // Create the fade transition for the root element
        FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        //Scene scene = new Scene(loader.load());
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
