package view.elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import jfxtras.scene.control.LocalDatePicker;
import org.controlsfx.control.PopOver;
import org.controlsfx.glyphfont.FontAwesome;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchTextField extends HBox {
    private final TextField field = new TextField();
    private final LocalDatePicker picker = new LocalDatePicker();
    private final PopOver over = new PopOver(picker);
    private final Button searchButton = new Button("Искать");
    private final StringProperty promptTextProperty = new SimpleStringProperty();
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public SearchTextField() {
        super();
        field.promptTextProperty().bind(promptTextProperty);
        field.setPrefColumnCount(20);
        over.setArrowSize(0);
        over.setArrowLocation(PopOver.ArrowLocation.TOP_CENTER);
        picker.getStylesheets().add(SearchTextField.class.getResource("datefield.css").toExternalForm());
        picker.getStyleClass().add("LocalDatePicker");
        picker.prefWidthProperty().bind(this.widthProperty());
        picker.setMode(LocalDatePicker.Mode.SINGLE);
        picker.setAllowNull(true);
        final Button showPicker = new Button();
        showPicker.setGraphic(MethodFX.getFontAwesome().create(FontAwesome.Glyph.CALENDAR_ALT));

        showPicker.setOnAction(event -> {
            if (over.isShowing())
                over.hide();
            else
                over.show(field, -2);
        });
        field.textProperty().addListener((obs, oldText, newText) -> {
            if(newText.matches("(^(((0[1-9]|1[0-9]|2[0-8])[.](0[1-9]|1[012]))|((29|30|31)[.](0[13578]|1[02]))|((29|30)[.](0[4,6,9]|11)))[.](19|[2-9][0-9])\\d\\d$)|(^29[.]02[.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)"))
                picker.localDateProperty().setValue(LocalDate.parse(newText, dateFormatter));
            else
                picker.localDateProperty().setValue(null);
        });
        picker.localDates().addListener((ListChangeListener<LocalDate>) c -> {
            while(c.next() && c.wasAdded()) {
                field.setText(dateFormatter.format(c.getAddedSubList().get(0)));
            }
            over.hide();
        });
        field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && over.isShowing())
                over.hide();
        });

        this.setSpacing(4);
        this.getChildren().addAll(field, showPicker, searchButton);
    }

    public String getText() { return field.getText(); }

    public LocalDate getLocalDate() { return picker.getLocalDate(); }

    public void hidePicker(Duration duration) { if (over.isShowing()) over.hide(duration); }

    public void setOnSearch(EventHandler<ActionEvent> eventHandler) { searchButton.setOnAction(eventHandler); }

    public StringProperty promptTextProperty() {
        return promptTextProperty;
    }

    public void setPromptText(String value) { promptTextProperty.setValue(value); }

    public String getPromptText() { return promptTextProperty.getValue(); }
}