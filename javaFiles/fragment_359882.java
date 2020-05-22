public class Label {

    private final StringProperty textProperty = new SimpleStringProperty() ;

    public String getText() {
        return textProperty().get();
    }

    // ...
}