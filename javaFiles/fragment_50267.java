import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    long    milliSeconds;
    String  unitAtLastChange;
    int     originalValue;

    @Override
    public void start(Stage stage) throws Exception {
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000));
        spinner.setEditable(true);

        ComboBox<String> comb = new ComboBox<>();
        comb.getItems().addAll("Milliseconds", "Seconds", "Minutes", "Hours", "Days");
        comb.getSelectionModel().selectFirst();
        this.unitAtLastChange = comb.getSelectionModel().getSelectedItem();

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> ov, Integer old_val, Integer new_val) {
                MainApp.this.unitAtLastChange = comb.getSelectionModel().getSelectedItem();
                MainApp.this.originalValue = new_val.intValue();

                switch (MainApp.this.unitAtLastChange) {
                    case "Milliseconds":
                        MainApp.this.milliSeconds = new_val.intValue();

                        break;
                    case "Seconds":
                        MainApp.this.milliSeconds = TimeUnit.SECONDS.toMillis(new_val.intValue());

                        break;
                    case "Minutes":
                        MainApp.this.milliSeconds = TimeUnit.MINUTES.toMillis(new_val.intValue());

                        break;
                    case "Hours":
                        MainApp.this.milliSeconds = TimeUnit.HOURS.toMillis(new_val.intValue());

                        break;
                    case "Days":
                        MainApp.this.milliSeconds = TimeUnit.DAYS.toMillis(new_val.intValue());
                        break;
                    default:
                        throw new RuntimeException("Error - wrong value");

                }

                System.out.println("Converted: " + MainApp.this.originalValue + " " + MainApp.this.unitAtLastChange + " Original: "
                        + MainApp.this.milliSeconds + " Milliseconds");
            }
        });

        comb.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                switch (newValue) {
                    case "Milliseconds":
                        MainApp.this.originalValue = (int) MainApp.this.milliSeconds;

                        break;
                    case "Seconds":
                        MainApp.this.originalValue = (int) TimeUnit.MILLISECONDS.toSeconds(MainApp.this.milliSeconds);

                        break;
                    case "Minutes":
                        MainApp.this.originalValue = (int) TimeUnit.MILLISECONDS.toMinutes(MainApp.this.milliSeconds);

                        break;
                    case "Hours":
                        MainApp.this.originalValue = (int) TimeUnit.MILLISECONDS.toHours(MainApp.this.milliSeconds);

                        break;
                    case "Days":
                        MainApp.this.originalValue = (int) TimeUnit.MILLISECONDS.toDays(MainApp.this.milliSeconds);
                        break;
                    default:
                        throw new RuntimeException("Error - wrong value");

                }
                spinner.getValueFactory().setValue(Integer.valueOf(MainApp.this.originalValue));
            }
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(spinner, comb);
        hb.setSpacing(50);

        Scene scene = new Scene(hb);

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}