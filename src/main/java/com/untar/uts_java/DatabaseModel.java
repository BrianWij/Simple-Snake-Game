package com.untar.uts_java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class DatabaseModel{

    String file = "src/assets/accounts/LeaderBoard.csv";
    String[][] data = readFile(file,3);

    private ObservableList<scoreboard> item;

    public DatabaseModel(){

        item = FXCollections.observableArrayList();
        for (int i = 1 ; i< data.length;i++){
            item.add(new scoreboard(data[i][0],data[i][1]));
        }
    }

    public ObservableList<scoreboard> getItem() {
        return item;
    }

    public void setItem(ObservableList<scoreboard> list) {
        this.item = list;
    }

    public static String[][] readFile(String filepath, int amountOfFields){
        java.util.List<String> recordlist = new ArrayList<String>();

        String delimiter = ",";
        String currentLine;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while((currentLine = reader.readLine()) != null){
                recordlist.add(currentLine);
            }
            int recordCount = recordlist.size();

            String arrayToReturn[][] = new String [recordCount][amountOfFields];
            String[] data;

            for (int i = 0; i < recordCount; i++){
                data = recordlist.get(i).split(delimiter);
                for(int j = 0; j < data.length; j++){
                    arrayToReturn[i][j] = data [j];
                }
            }
            return  arrayToReturn;
        }
        catch (Exception e){
            System.out.println(e);

            return null;
        }
        finally {

        }
    };
}
