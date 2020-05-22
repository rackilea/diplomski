public class MainDriversController{

    @FXML
    private ListView<String> driversLV;

    private ObservableList<String> observableList = FXCollections.observableArrayList();

    public void initialize(){
        for(int x=0; x<Cparsing.driversNodes.getLength(); x++) {
            observableList.add(Cparsing.driversNodes.item(x).getAttributes().getNamedItem("nick").getNodeValue());
        }
        driversLV.setItems(observableList);
        System.out.println(driversLV);
    }
}