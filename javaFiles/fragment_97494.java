package sample;

import javafx.application.Application;
import javafx.scene. Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Random Number Generator");
        HBox layout = new HBox();
        layout.setPadding(new Insets(25,12,15,20));
        layout.setSpacing(10);
        Scene scene = new Scene(layout, 400, 80);
        primaryStage.setScene(scene);

        TextField text = new TextField();
        text.setMinWidth(200);
        text.setMaxWidth(110);
        Button button = new Button("Submit");
        button.setOnAction(e -> {
            RandGen(text, text.getText());
        }); //Eventhandler

        Label label = new Label();
        label.setText("From 0 to :");
        layout.getChildren().addAll(label, text, button);

        primaryStage.show();
    }

    //start of functionalities
    private void RandGen(TextField input, String Message){

        Random rnd = new Random();

        try{
            double number = Double.parseDouble(Message);
            double rndNum = 0 + number * rnd.nextDouble();
//          input.setText(Double.toString(rndNum));
            input.setText(Double.valueOf(rndNum).toString());
//          System.out.println("The generated number from 0 to " + input.getText() +"is " + Random);
        }catch(NumberFormatException e){
            System.out.println("'" + Message + "' is not a number");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}