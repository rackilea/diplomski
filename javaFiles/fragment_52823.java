public class Model {

    public ObservableList<StringProperty> listOfStringsProperty;

    public Model(){
        listOfStringsProperty = FXCollections.observableArrayList();    
    }

}