import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication249 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Menu miFile = new Menu("File");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(miFile);

        VBox root = new VBox(menuBar);

        Scene scene = new Scene(root, 300, 250);

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