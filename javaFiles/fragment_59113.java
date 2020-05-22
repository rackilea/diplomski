package sample;

import eu.hansolo.enzo.gauge.RectangularGauge;
import gnu.io.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.*;

public class Main extends Application implements SerialPortEventListener {

    SerialPort serialPort = null;
    private BufferedReader serialIn;
    private OutputStream serialOut;


    private Controller controller ;    

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        controller = loader.getController();

        primaryStage.setTitle("Power Meter");
        primaryStage.setScene(new Scene(root, 380, 320));
        primaryStage.show();

        //
        CommPortIdentifier port = CommPortIdentifier.getPortIdentifier("COM60");
        CommPort commPort = port.open(this.getClass().getName(), 2000);
        serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        serialIn = new BufferedReader(new InputStreamReader((serialPort.getInputStream())));
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
        //
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void serialEvent(SerialPortEvent e) {
        try {
            String line = serialIn.readLine();
            String[] values = line.split(",");
            final double power = Double.parseDouble(values[1]);
            System.out.println(power / 5);
            Platform.runLater(() -> controller.setFwdpower(power/5));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}