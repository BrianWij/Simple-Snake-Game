package com.untar.uts_java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private TableView<scoreboard> scoreTable;
    @FXML
    private TableColumn<scoreboard,String> name;
    @FXML
    private TableColumn<scoreboard,String> score;

    private DatabaseModel model = new DatabaseModel();

    public void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<scoreboard,String>("name"));
        score.setCellValueFactory(new PropertyValueFactory<scoreboard,String>("score"));
        name.setSortable(false);
        score.setSortType(TableColumn.SortType.DESCENDING);
        scoreTable.getSortOrder().add(score);
        scoreTable.sort();
        scoreTable.setItems(model.getItem());
    }
}
