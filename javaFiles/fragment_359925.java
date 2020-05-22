package de.professional_webworkx.reservationmanager;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 */
public class ReservationManager extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(parent);

        primaryStage.setTitle("Hotel Reservation Manager v1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}