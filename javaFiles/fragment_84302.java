public class Model {

    private final StringProperty text = new SimpleStringProperty();

    public final String getText() { return text.get(); }
    public final void setText(String value) { text.set(value); }
    public final StringProperty textProperty() { return text; }

}