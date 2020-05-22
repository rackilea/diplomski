import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LayoutTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 1280, 720);

        MenuBar menuBar  = new MenuBar();
        Menu    menuFile = new Menu("File");
        Menu    menuEdit = new Menu("Edit");
        Menu    menuView = new Menu("View");
        Menu    menuHelp = new Menu("Help");

        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuHelp);
        borderPane.setTop(menuBar);

        TextArea textArea = new TextArea();
        borderPane.setCenter(textArea);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}