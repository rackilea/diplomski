import java.util.function.BiPredicate;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class DependentComboBoxes extends Application {

    private ComboBox<Integer> startHours ;
    private ComboBox<Integer> endHours ;

    @Override
    public void start(Stage primaryStage) {
        startHours = new ComboBox<>();
        endHours = new ComboBox<>();
        startHours.setCellFactory(lv -> new StartHoursCell());
        endHours.setCellFactory(lv -> new EndHoursCell());
        for (int i = 0; i < 24 ; i++) {
            startHours.getItems().add(i);
            endHours.getItems().add(i);
        }

        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.addRow(0, new Label("Start hours:"), startHours);
        root.addRow(1, new Label("End hours:"), endHours);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private class StartHoursCell extends ListCell<Integer> {

        StartHoursCell() {
            endHours.valueProperty().addListener((obs, oldEndHours, newEndHours) -> updateDisableState());
        }

        @Override
        protected void updateItem(Integer hours, boolean empty) {
            super.updateItem(hours, empty);
            if (empty) {
                setText(null);
            } else {
                setText(hours.toString());
                updateDisableState();
            }
        }

        private void updateDisableState() {
            boolean disable = getItem() != null && endHours.getValue() != null && 
                    getItem().intValue() > endHours.getValue();
            setDisable(disable) ;
            setOpacity(disable ? 0.5 : 1);
        }
    }

    private class EndHoursCell extends ListCell<Integer> {

        EndHoursCell() {
            startHours.valueProperty().addListener((obs, oldEndHours, newEndHours) -> updateDisableState());
        }

        @Override
        protected void updateItem(Integer hours, boolean empty) {
            super.updateItem(hours, empty);
            if (empty) {
                setText(null);
            } else {
                setText(hours.toString());
                updateDisableState();
            }
        }

        private void updateDisableState() {
            boolean disable = getItem() != null && startHours.getValue() != null && 
                    getItem().intValue() < startHours.getValue();
            setDisable(disable) ;
            setOpacity(disable ? 0.5 : 1);

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}