import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TableOfControlsInGridPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(table(10));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane table(int rows){
        GridPane table = new GridPane();

        for(int i=0; i<rows; i++){
            TextField textField = new TextField();
            textField.setAlignment(Pos.CENTER);
            TextField textField2 = new TextField();
            textField2.setAlignment(Pos.CENTER);
            CheckBox checkBox = new CheckBox("Check Box");
            checkBox.setTextFill(Color.WHITE);
            checkBox.setAlignment(Pos.CENTER);
            TextField textField3 = new TextField();
            textField3.setAlignment(Pos.CENTER);

            table.add(textField, 0, i);
            table.add(textField2, 1, i);
            table.add(checkBox , 2, i);
            table.add(textField3,3, i);

            ChangeListener<Object> listener = (obs, oldValue, newValue) -> 
                updateTotalField(textField.getText(), textField2.getText(), checkBox.isSelected(), textField3);

            textField.textProperty().addListener(listener);
            textField2.textProperty().addListener(listener);
            checkBox.selectedProperty().addListener(listener);

            GridPane.setMargin(textField, new Insets(5));
            GridPane.setMargin(textField2, new Insets(5));
            GridPane.setMargin(checkBox, new Insets(5));
            GridPane.setMargin(textField3, new Insets(5));
         }
        table.setAlignment(Pos.CENTER);

        return table;
    }

    private void updateTotalField(String text1, String text2, boolean addPause, TextField output) {
        int value1 = parseText(text1);
        int value2 = parseText(text2);
        int total = value1 + value2 ;
        if (addPause) {
            total += 10 ;
        }
        output.setText(Integer.toString(total));
    }

    private int parseText(String text) {
        // if text is a valid integer:
        if (text.matches("\\d+")) {
            return Integer.parseInt(text);
        } else {
            return 0 ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}