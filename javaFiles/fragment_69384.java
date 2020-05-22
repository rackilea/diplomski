package sample;
public class Controller implements Initializable {
public ComboBox Cb_tipusDocument;
@Override
public void initialize(URL location, ResourceBundle resources) {
    ObservableList<String> ol_str_llistatPerSelect = 
    FXCollections.observableArrayList("A", "B", "C");
    Cb_tipusDocument.setItems(ol_str_llistatPerSelect);
}
public void executar(ActionEvent actionEvent) {
    if ( Cb_tipusDocument.getValue() == null) {        
        //...
    }else {
        //...
    }
}