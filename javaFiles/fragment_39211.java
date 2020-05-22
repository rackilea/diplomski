import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication95 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        FlowPane flowPane = new FlowPane();

        List<Circle> circleContainer = new ArrayList();
        for(int i = 0; i < 5; i++)
        {
            Circle c1 = new Circle();
            c1.setRadius(50);
            c1.setFill(Color.BLUE);
            circleContainer.add(c1);
        }

        flowPane.getChildren().addAll(circleContainer);
//        flowPane.maxHeight(500);
//        flowPane.setMaxWidth(300);
        flowPane.setPadding(new Insets(30, 30, 30, 30));
        StackPane root = new StackPane();
        root.getChildren().add(flowPane);

        Scene scene = new Scene(root, 600, 400);


        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}