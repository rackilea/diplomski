import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AutoSaveExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        Spinner<Integer> saveIntervalSpinner = new Spinner<>(1, 60, 1);

        AutoSaveService autoSaveService = new AutoSaveService();
        autoSaveService.periodProperty().bind(Bindings.createObjectBinding(
                () -> Duration.seconds(saveIntervalSpinner.getValue()), 
                saveIntervalSpinner.valueProperty()));
        autoSaveService.start();

        VBox root = new VBox(5, new Label("Save Interval:"), saveIntervalSpinner);
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPadding(new Insets(18));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class AutoSaveService extends ScheduledService<Void> {
        @Override
        protected Task<Void> createTask() {
            // retrieve data from UI. This should be done here,
            // as you should access the data on the FX Application Thread
//          final MyDataType data = getDataFromUI(); 
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
//                  vb.save(data);
                    System.out.println("Save at "+System.currentTimeMillis());
                    return null ;
                }
            };
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}