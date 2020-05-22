import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application
{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {
        VBox vBox = new VBox();

        HBox hBox1 = generateComboBoxHBox();
        HBox hBox2 = generateComboBoxHBox();
        HBox hBox3 = generateComboBoxHBox();
        HBox hBox4 = generateComboBoxHBox();
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);

        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }

    // Create 4 of the same HBoxes for an example. Each HBox has a checkbox and combobox
    private HBox generateComboBoxHBox(){
        HBox hBox = new HBox();
        CheckBox checkBox = new CheckBox();
        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList("Option1", "Option2", "Option3", "Option4"));

        comboBox.disableProperty().bind(checkBox.selectedProperty().not());

        hBox.getChildren().addAll(checkBox, comboBox);
        return hBox;
    }

}