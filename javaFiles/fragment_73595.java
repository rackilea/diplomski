public class ListCellView   extends CellView
{
    @FXML private Label             label1;
    @FXML private Label             label2;


    @Override
    public void setInfo( MyObject myObject ){

       label1.setText( myObject.getDay() );
       label2.setText( Integer.toString( myObject.getNumber() ) );

       label1.setTextFill( myObject.getColor() );
    }


        /**
         *  Initialize
         *    -- must use java -ea <program>, to check asserts
         **/
    @FXML
    @Override
    protected void initialize() {

        super.initialize();

        assert label1       != null : "fx:id=\"label1\" was not injected: check your FXML file 'CustomCell.fxml'.";
        assert label2       != null : "fx:id=\"label2\" was not injected: check your FXML file 'CustomCell.fxml'.";
    }

}//ListCellView