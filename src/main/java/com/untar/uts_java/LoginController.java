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
import javafx.stage.Window;
import javafx.fxml.Initializable;
import java.net.URL;
import java.io.*;

public class LoginController {
    public LoginController() {

    }

    @FXML
    private Button loginButton;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField enterUsername;
    @FXML
    private PasswordField enterPassword;

    public void Login_Handler(ActionEvent event) throws IOException {
        checkLogin();

    }

    public void goto_Register(ActionEvent event) throws IOException {
        MainApplication m = new MainApplication();
        m.changeScene("Register.fxml");

    }

    private void checkLogin() throws IOException {
        if(enterUsername.getText().equals(enterUsername.getText()) && enterPassword.getText().equals(enterPassword.getText())) {
            File file = new File("src/assets/accounts/User.csv");
            BufferedReader reader = null;
            String line = "";
            try{
                reader = new BufferedReader(new FileReader(file));
                int counter = 0;
                while((line = reader.readLine()) != null){//read per-line
                    String[] row = line.split(",");
                    if(row[0].equals(enterUsername.getText()) && row[1].equals(enterPassword.getText())){
                        counter = counter + 1;
                        break;
                    }
                    else if (row[0].equals(enterUsername.getText()) && !row[1].equals(enterPassword.getText())){
                        wrongLogIn.setText("Password yang Anda masukan salah!");
                        break;
                    }
                    else{
                        wrongLogIn.setText("User tidak ditemukan mohon melakukan registrasi");
                    }
                }
                if (counter>0){
                    String username = enterUsername.getText();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                    loader.load();
                    MainController y = loader.getController();
                    y.sentText(username);
                    Parent p = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p,700,700));
                    stage.show();
                    stage.setResizable(false);
                    stage.getScene().setRoot(p);
                    wrongLogIn.setText("");
                    MainApplication m = new MainApplication();
                    m.ExitButtonListener();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                reader.close();
            }
        }

        else if(enterUsername.getText().isEmpty() && enterPassword.getText().isEmpty()) {
            wrongLogIn.setText("Anda tidak memasukan user dan password.");
        }

        else if(enterPassword.getText().isEmpty()) {
            wrongLogIn.setText("Mohon masukan password Anda.");
        }
    }
}
