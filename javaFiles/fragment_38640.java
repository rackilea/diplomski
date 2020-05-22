package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.DialogManager;
import sample.ControllerMain;

public class ControllerFind {

    //Window "Find"
    @FXML public TextField searchTextField;
    @FXML public Label findTextLabel;
    @FXML public Button okTextFindButton;
    @FXML public Button cancelTextFindButton;
    private String text;
    private ControllerMain controller;

    public void setParent (ControllerMain controller){
        this.controller = controller;
    }

    public ControllerFind getThis(){
        return this;
    }

    public void initialize(){
        System.out.println("psvm");
    }

    public void textFindOkButtonAction(ActionEvent actionEvent) {
        text = (searchTextField.getText());
        if (text.equals("")) {
            DialogManager.showInfoDialog("Error!", "Enter text what you are looking for!");
        } else {
            if (controller.textAreaOne.getText() != null && !controller.textAreaOne.getText().isEmpty()) {
                int index = controller.textAreaOne.getText().indexOf(text);
                if (index == -1) {
                    DialogManager.showInfoDialog("Result", "There isn't text what you are looking for");
                } else {
                    controller.textAreaOne.selectRange(index, index + text.length());
                }
            } else {
                DialogManager.showInfoDialog("Error", "TextArea is empty!");
            }
        }
    }

    public void textFindCancelButtonAction(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}