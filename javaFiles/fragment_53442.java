import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        TextField textbox = new TextField();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.google.com/");

        textbox.setOnKeyPressed(ke -> {
            if(ke.getCode() == KeyCode.ENTER){

                System.out.println("Enter pressed!");

                if(vbox.isResizable()) {
                    System.out.println("It's Resizable!");
                    vbox.resize(300, 200);     //doesn't work!
                }
            }
        });

        vbox.getChildren().addAll(textbox,webView);
        Scene scene = new Scene(vbox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}