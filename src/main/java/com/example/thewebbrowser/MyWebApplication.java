package com.example.thewebbrowser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MyWebApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyWebApplication.class.getResource("myWeb-view.fxml"));
        stage.getIcons().add(new Image("E:\\Studying\\java\\TheWebBrowser\\src\\main\\resources\\halal-logo-150ED752BD-seeklogo.com.png"));

        Scene scene = new Scene(fxmlLoader.load(),1280,800);
        stage.setTitle("The Halal Net");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}