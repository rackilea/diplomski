import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleLabelTextFiledApp extends Application {
    private final ObservableList<CustomControl> customControls = FXCollections.observableArrayList();
    private final List<String> labels = Arrays.asList("label1", "label2", "label3", "label4", "label5");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        labels.stream().forEach(label -> customControls.add(new CustomControl(label)));

        VBox vBox = new VBox();
        vBox.getChildren().setAll(customControls);

        stage.setScene(new Scene(vBox));
        stage.show();

        getCustomControl("label1").ifPresent(customControl -> {
            customControl.getTextField().textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
                System.out.println("textField with label1 handler new text=" + newValue);
            });
        });
    }

    private Optional<CustomControl> getCustomControl(String labelText) {
        return customControls.stream()
        .filter(customControl -> labelText.equals(customControl.getLabel().getText()))
        .findFirst();
    }
}

class CustomControl extends HBox {

    private final Label label = new Label();
    private final TextField textField = new TextField();

    {
        getChildren().addAll(label, textField);
    }

    public CustomControl(String text) {
        label.setText(text);
    }

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }
}