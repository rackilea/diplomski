import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline; 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GeneralTesting extends Application{
    private Text text;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        text = new Text(500, 300, "0");

        text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 100));

        IntegerProperty counter = new SimpleIntegerProperty(1);
        text.textProperty().bind(counter.asString());

        Animation animation = new Timeline(new KeyFrame(Duration.millis(1000), 
            e -> counter.set((counter.get()+1) % 5)));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        pane.getChildren().addAll(text);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}