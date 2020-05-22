public class AppController implements Initializable
{
    @FXML private Button myButton;

    @FXML private ListView myListView;

    // ObservableList is a List
    protected ObservableList<String> list = new FXCollections.observableArrayList();

    protected int counter = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        myListView.setItems(list);

        myButton.setOnAction(new EventHandler<ActionEvent>()
        {@Override public void handle(ActionEvent event)
        {
            list.add(counter++);
        }});
    }
}