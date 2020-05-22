import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class WeatherBox extends VBox {

    @FXML
    private Label date;
    @FXML
    private Label description;
    @FXML
    private Label temperature;
    @FXML
    private Label percipitation;
    @FXML
    private Button details;
    @FXML
    private ImageView img;

    public WeatherBox() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WeatherBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    @FXML
    protected void forecastDetails() {
        System.out.println("The button was clicked!");
    }


    public String getDateText() {
        return date.getText();
    }

    public void setDateText(String dateText) {
        this.date.setText(dateText);
    }

    public String getDescriptionText() {
        return description.getText();
    }

    public void setDescriptionText(String dateText) {
        this.description.setText(dateText);
    }
}