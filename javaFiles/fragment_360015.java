import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MixedTextAndIconFonts extends Application {
    @Override public void start(Stage stage) {
        Text i = new Text("I");
        Text love = new Text("\uE87D");
        Text u = new Text("you");
        i.setStyle("-fx-font-family: \'Indie Flower\'; -fx-font-size: 80; -fx-fill: forestgreen;");
        love.setStyle("-fx-font-family: \'Material Icons\'; -fx-font-size: 60; -fx-fill: firebrick;");
        u.setStyle("-fx-font-family: \'Indie Flower\'; -fx-font-size: 80; -fx-fill: forestgreen;");

        TextFlow textFlow = new TextFlow(
                i,
                love,
                u
        );
        textFlow.setStyle("-fx-padding: 20px; -fx-background-color: azure;");

        Scene scene = new Scene(textFlow);
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Indie+Flower");
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Material+Icons");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}