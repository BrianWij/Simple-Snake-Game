package com.untar.uts_java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.*;


public class RegisterController {

    public RegisterController() {

    }

    @FXML
    private Button registerButton;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField enterUsername;
    @FXML
    private PasswordField enterPassword;
    @FXML
    private PasswordField recheckPassword;

    public void Register_Handler(ActionEvent event) throws IOException {
        save_account();

    }

    public void goto_Login(ActionEvent event) throws IOException {
        MainApplication m = new MainApplication();
        m.changeScene("Login.fxml");
    }

    private void save_account() throws IOException {
        if(enterUsername.getText().equals(enterUsername.getText()) && enterPassword.getText().equals(enterPassword.getText()) && recheckPassword.getText().equals(enterPassword.getText())) {
            File file = new File("src/assets/accounts/User.csv");
            BufferedReader reader = null;
            String line = "";
            try{
                reader = new BufferedReader(new FileReader(file));
                int counter = 0;
                while((line = reader.readLine()) != null){//read per-line
                    String[] row = line.split(",");
                    if(row[0].equals(enterUsername.getText())){
                        counter = counter + 1;
                    }
                }
                if (counter>0){
                    wrongLogIn.setText("User sudah ada.");
                }
                else {
                    FileWriter writer= new FileWriter(file, true);
                    writer.append(enterUsername.getText()).append(",").append(enterPassword.getText()).append("\n");
                    writer.close();
                    wrongLogIn.setText("Register Successfully!");//simpan user dan password
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                reader.close();
            }
        }

        else if(enterUsername.getText().isEmpty() && enterPassword.getText().isEmpty() && recheckPassword.getText().isEmpty()) {
            wrongLogIn.setText("Please enter all your data.");
        }
        else if(enterPassword.getText().isEmpty() && recheckPassword.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your password.");
        }
        else if(recheckPassword.getText() != enterPassword.getText()) {
            wrongLogIn.setText("Password is different.");
        }
    }

}
