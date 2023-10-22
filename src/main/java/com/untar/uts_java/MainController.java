package com.untar.uts_java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.*;
import java.util.Objects;

public class MainController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button startGame,showScore,logoutButton;
    String User;
    public void Back(ActionEvent event) throws IOException {
        MainApplication m = new MainApplication();
        m.OpenButtonListener();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
    public String sentText(String user){
        welcomeText.setText("Welcome " + user);
        User = user;
        return User;
    }
    public void Start(ActionEvent event) throws IOException{
        File file = new File("src/assets/accounts/LeaderBoard.csv");
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            FileWriter writer= new FileWriter(file, true);
            writer.append(User).append(",");
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            reader.close();
        }
        new GameFrame();
    }
    public void openScore(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Score_Board.fxml")));;
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

}