public abstract class CellView
{
    @FXML private ResourceBundle    resources;
    @FXML private URL               location;
    @FXML private AnchorPane        customCell;
    @FXML private HBox              hBox;

    public abstract void setInfo( MyObject myObject );

    public HBox getBox() {

        return hBox;
    }

    protected void initialize() {

        assert customCell   != null : "fx:id=\"customCell\" was not injected: check your FXML file 'CustomCell.fxml'.";
        assert hBox         != null : "fx:id=\"hBox\" was not injected: check your FXML file 'CustomCell.fxml'.";
    }

    public  CellView(){
    }

}//CellView