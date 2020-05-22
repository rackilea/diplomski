public class AStringAndAnIntController extends GridPane implements Initializable{
    @FXML Label str;
    @FXML Label integer;

    @Override public void initialize(URL arg0, ResourceBundle arg1){
    }
    public void setAStringAndAnInt(AStringAndAnInt strint){
        str.textProperty().bind(strint.strProperty());
        integer.textProperty().bind(strint.integerProperty().asString());
    }
}