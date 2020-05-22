public class CustomControl extends AnchorPane implements Initializable {
    String customId;

    public CustomControl() {
        //if you want to set a FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/res/customControl.fxml"));
        //Defines this class as the controller
        fxmlLoader.setRoot(this);
        //this.getStylesheets().add("/res/style.css"); <- if you want to set a css
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
        public String getCustomId() {
            return customId;
        }
    public void setCustomId(String customId) {
        return this.customId = customId;
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
          //Initializes the controller
    }
}