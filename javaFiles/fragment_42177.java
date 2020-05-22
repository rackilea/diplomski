public class ModifyController {

    @FXML
    private TextField valueTxtFld;
    @FXML
    private Button mdfSaveBtn;

    private myData data;

    // flag indicating, if the edit was submitted or not
    private boolean edited;

    public boolean isEdited() {
        return edited;
    }

    public void setData(myData selectedItem) {
        if (selectedItem == null) {
            throw new IllegalArgumentException();
        }
        this.data = selectedItem;
        valueTxtFld.setText(selectedItem.getValue());
        edited = false;
    }

    public void save() {
        data.setValue(valueTxtFld.getText());
        edited = true;
        mdfSaveBtn.getScene().getWindow().hide();
    }

}