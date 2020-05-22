import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalTimeStringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    DatePicker datePicker = new DatePicker();
    datePicker.setValue(LocalDate.now());

    TextField timeField = new TextField();
    TextFormatter<LocalTime> timeFieldFormatter =
        new TextFormatter<>(new LocalTimeStringConverter());
    timeField.setTextFormatter(timeFieldFormatter);
    timeFieldFormatter.setValue(LocalTime.now());

    HBox dateTimeBox = new HBox(10, datePicker, timeField);
    dateTimeBox.setAlignment(Pos.CENTER);

    ObjectBinding<LocalDateTime> ldtBinding = Bindings.createObjectBinding(() -> {
      LocalDate date = datePicker.getValue();
      LocalTime time = timeFieldFormatter.getValue();
      return date == null || time == null ? null : LocalDateTime.of(date, time);
    }, datePicker.valueProperty(), timeFieldFormatter.valueProperty());

    Label ldtLabel = new Label();
    ldtLabel.textProperty().bind(Bindings.createStringBinding(() -> {
      LocalDateTime dateTime = ldtBinding.get();
      return dateTime == null ? null : dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }, ldtBinding));

    VBox root = new VBox(15, dateTimeBox, ldtLabel);
    root.setAlignment(Pos.CENTER);
    root.setPadding(new Insets(25));

    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }
}