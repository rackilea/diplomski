import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TabStyleTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Tab 1");
        tab1.setContent(new StackPane(new Label("Tab 1")));
        tab1.setStyle("-tab-text-color: green;");
        Tab tab2 = new Tab("Tab 2");
        tab2.setContent(new StackPane(new Label("Tab 2")));
        tabPane.getTabs().addAll(tab1, tab2);
        Scene scene = new Scene(tabPane, 600, 600) ;
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}