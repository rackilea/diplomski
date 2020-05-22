public class FXMLDocumentController {

    @FXML public TextArea textArea;
    String selectedText = ""; // why is this field necessary???

    // controller for FXMLHeadings.fxml is automatically injected here
    @FXML private HeadingsController fxmlheadingsController;

    public String getSelectedTextfromTextArea(){
        selectedText =  textArea.getSelectedText();
        return selectedText;
    }

    public void replaceSelectedText(String string){
        textArea.replaceSelection(string);
    }

    @FXML public void initialize() {
        fxmlheadingsController.init(this);
        textArea.setWrapText(true);
    }   

}