package projecterror.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainWindowController {

    @FXML
    private BorderPane mainWindow;

    @FXML
    Menu menuFile, menuAnalysis;
    @FXML
    MenuItem menuNew;


    @FXML
    private void initialize() {
        menuNew.setOnAction((event) -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/AnchorTest.fxml"));
                AnchorPane anchorTest = (AnchorPane) loader.load();
                mainWindow.setCenter(anchorTest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



}