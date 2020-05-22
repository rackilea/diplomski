import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleLayoutExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        TabPane tabs = new TabPane();

        tabs.getTabs().add(createTab(new StackPane()));
        tabs.getTabs().add(createTab(new VBox()));
        tabs.getTabs().add(createTab(new Pane()));
        tabs.getTabs().add(createTab(new Group()));

        Scene scene = new Scene(tabs, 600, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private Tab createTab(Pane pane) {
        Circle c1 = new Circle(150, 150, 50, Color.RED);
        Circle c2 = new Circle(400, 400, 50, Color.YELLOW);

        pane.getChildren().addAll(c1, c2);

        Tab tab = new Tab(pane.getClass().getSimpleName());
        tab.setContent(pane);
        return tab ;
    }

    // annoyingly, Pane and Group do not have a common superclass with a getChildren()
    // method, so just reproduce the code...
    private Tab createTab(Group pane) {
        Circle c1 = new Circle(150, 150, 50, Color.RED);
        Circle c2 = new Circle(400, 400, 50, Color.YELLOW);

        pane.getChildren().addAll(c1, c2);

        Tab tab = new Tab(pane.getClass().getSimpleName());
        tab.setContent(pane);
        return tab ;
    }
    public static void main(String[] args) {
        launch(args);
    }
}