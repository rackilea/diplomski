public class ContactCellController {

    @FXML
    private Label labelName ;
    @FXML
    private Label labelStatus ;
    @FXML
    private Label labelSense ;
    @FXML
    private ImageView avatar ;

    public void setName(String name) {
        labelName.setText(name);
    }

    public void setStatus(String status) {
        labelStatus.setText(status);
    }

    public void setSense(String sense) {
        labelSense.setText(sense);
    }

    public void setAvatarImage(Image image) {
        avatar.setImage(image);
    }
}