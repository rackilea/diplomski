import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication50 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        VBox vboxRight = new VBox(); //This is the right VBox
        vboxRight.setSpacing(10);
        //This HBox represents the first "Line"
        HBox hboxLine = new HBox();
        hboxLine.setSpacing(10);
        hboxLine.setMinHeight(30);
        //Textbox
        TextField txtField = new TextField();
        txtField.setMinHeight(30);

        //Button
        Button btn = new Button("Search");
        btn.setMinHeight(30);
        //btn.setOnAction(this);
        HBox.setHgrow(txtField, Priority.ALWAYS);//Added this line
        HBox.setHgrow(btn, Priority.ALWAYS);//Added this line
        hboxLine.getChildren().addAll(txtField, btn);
        vboxRight.getChildren().addAll(hboxLine);

        Scene scene = new Scene(vboxRight, 300, 250);

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