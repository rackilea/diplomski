public class FXMLDocumentController { 
    @FXML
    private TextArea chatBox ;

    public void appendMessage(String message) {
        chatBox.appendText(message);
    }

    // other stuff as before...
}