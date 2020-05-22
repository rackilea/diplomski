package view_FXML;

import Model.Curse;
import Model.Participant;
import Service.GeneralService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchViewController {
    @FXML
    private ListView<Participant> listView;

private GeneralService service;
private ObservableList<Participant> model;

public void setService(GeneralService service){
    this.service=service;
    //this.model= FXCollections.observableArrayList(service.vizualizareParticipanti());
    Participant  p = new Participant(1,"Laszlo",1,100,2);
    Participant p2 = new Participant(2,"John",2,123,100);
    this.model= FXCollections.observableArrayList(p,p2);
    listView.setItems(model);
    listView.setCellFactory(new Callback<ListView<Participant>, 
    ListCell<Participant>>() {

        @Override
        public ListCell<Participant> call(ListView<Participant> param) {
            ListCell<Participant> cell = new ListCell<Participant>() {

                @Override
                protected void updateItem(Participantitem, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item.getId() + ": " + item.getName() + " " + item.etc());
                    } else {
                        setText("");
                    }
                }
            };
            return cell;
        }
    });
}
 // public void initialize(){
 // }
}