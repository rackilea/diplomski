package sample;

import eu.hansolo.enzo.gauge.RectangularGauge;
import gnu.io.SerialPortEvent;
import javafx.fxml.FXML;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller {

    @FXML
    private RectangularGauge fwdpower ;

    public void setFwdPower(double power) {
        fwdpower.setValue(power);
    }
}