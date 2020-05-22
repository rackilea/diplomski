import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Touch extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setScene(new WelcomeScene(new StackPane(),
                screenBounds.getWidth(), screenBounds.getHeight()));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}