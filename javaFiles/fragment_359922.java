package de.professional_webworkx.reservationmanager.controller;

import de.professional_webworkx.reservationmanager.business.ReservationService;
import de.professional_webworkx.reservationmanager.model.Reservation;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Main FXML Controller
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class MainController implements Initializable {

    @FXML
    TableView<Reservation> reservationTable;

    @FXML
    TableColumn<Reservation, Integer> resNumber;

    @FXML
    TableColumn<Reservation, String> customerName;

    @FXML
    TableColumn<Reservation, ObjectProperty<LocalDateTime>> checkIn;

    @FXML
    TableColumn<Reservation, ObjectProperty<LocalDateTime>> checkOut;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ReservationService service = new ReservationService();
        List<Reservation> allReservations = service.getAllReservations();
        reservationTable.getItems().addAll(allReservations);
        resNumber.setCellValueFactory(new PropertyValueFactory<>("reserveNumber"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
    }


}