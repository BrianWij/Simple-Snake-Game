package com.untar.uts_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;


public class MainApplication extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        stg.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        stg.setTitle("UTS Untar Java");
        stg.setScene(new Scene(root,700,500));
        stg.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }
    public void  ExitButtonListener() {
        stg.close();
    }
    public void OpenButtonListener(){
        stg.show();
    }
}