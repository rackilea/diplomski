import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField tf = new TextField();
        BorderPane root = new BorderPane();
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10.0);
        gp.setVgap(10.0);
        root.setTop(tf);

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");
        Button buttonDOT = new Button(".");
        Button buttonDIV = new Button("/");
        Button buttonMUL = new Button("*");
        Button buttonSUB = new Button("-");
        Button buttonADD = new Button("+");
        Button buttonEQU = new Button("=");
        setButtonSize(button1);
        setButtonSize(button2);
        setButtonSize(button3);
        setButtonSize(button4);
        setButtonSize(button5);
        setButtonSize(button6);
        setButtonSize(button7);
        setButtonSize(button8);
        setButtonSize(button9);
        setButtonSize(button0);
        setButtonSize(buttonDOT);
        setButtonSize(buttonDIV);
        setButtonSize(buttonMUL);
        setButtonSize(buttonSUB);
        setButtonSize(buttonADD);
        setButtonSize(buttonEQU);

        gp.add(button7, 0, 0);
        gp.add(button8, 1, 0);
        gp.add(button9, 2, 0);
        gp.add(buttonDIV, 3, 0);

        gp.add(button4, 0, 1);
        gp.add(button5, 1, 1);
        gp.add(button6, 2, 1);
        gp.add(buttonMUL, 3, 1);

        gp.add(button1, 0, 2);
        gp.add(button2, 1, 2);
        gp.add(button3, 2, 2);
        gp.add(buttonSUB, 3, 2);

        gp.add(button0, 0, 3);
        gp.add(buttonDOT, 1, 3);
        gp.add(buttonEQU, 2, 3);
        gp.add(buttonADD, 3, 3);

        root.setCenter(gp);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public void setButtonSize(Button button){
        button.setPrefHeight(35.0);
        button.setPrefWidth(35.0);
    }
}