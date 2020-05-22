public class DialogController {
    private final StringProperty message = new SimpleStringProperty("");
    public void setMessage(String message) {
        this.message.set(message);
    }
    public String getMessage() {
        return message.get();
    }
    public StringProperty messageProperty() {
        return message ;
    }

    @FXML
    private Label label ;

    public void initialize() {
        label.textProperty().bind(message);
        // ...
    }
}