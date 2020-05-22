public class CustomListView
{
    @FXML private ResourceBundle        resources;
    @FXML private URL                   location;
    @FXML private ListView<MyObject>    listView;

    List<MyObject>                      myList              = prepareMyList();
    ObservableList<MyObject>            myObservableList    = FXCollections.observableList( this.myList );


    private void setListView(){

        this.listView.setItems( this.myObservableList );

        listView.setCellFactory(
            new Callback<ListView<MyObject>, javafx.scene.control.ListCell<MyObject>>() {
                @Override
                public ListCell<MyObject> call(ListView<MyObject> listView) {
                    return new CustomListCell();
                }
            }//callback
        );//setCellFactory

    }//setListView

        /**
         * Initializes the controller class.
         */
    @FXML
    void initialize() {

        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'CustomList.fxml'.";

        this.setListView();
    }

        /**
         *  Prepare My List
         *    - Create dummy list of Views and data = MyObject-s
         **/
    private List<MyObject> prepareMyList() {

        final String    FXML_VIEW = "/fxml/ListCell.fxml";
        List<MyObject>  newList   = new ArrayList<>();

        newList.add(new MyObject( FXML_VIEW, "Sunday",    50, Color.RED        ));
        newList.add(new MyObject( FXML_VIEW, "Monday",    60, Color.GREEN      ));
        newList.add(new MyObject( FXML_VIEW, "Tuesday",   20, Color.BLUE       ));
        newList.add(new MyObject( FXML_VIEW, "Wednesday", 90, Color.VIOLET     ));
        newList.add(new MyObject( FXML_VIEW, "Thursday",  30, Color.BLUEVIOLET ));
        newList.add(new MyObject( FXML_VIEW, "Friday",    62, Color.BROWN      ));
        newList.add(new MyObject( FXML_VIEW, "Saturday",  65, Color.GOLD       ));

        return newList;
    }

}//CustomListView