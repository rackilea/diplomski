import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private final StringProperty text = new SimpleStringProperty(this, "text", "");

    public final StringProperty textProperty() {
        return this.text;
    }

    public final java.lang.String getText() {
        return this.textProperty().get();
    }

    public final void setText(final java.lang.String text) {
        this.textProperty().set(text);
    }

    public DataModel(String text) {
        setText(text);
    }
}