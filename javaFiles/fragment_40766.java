import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleDefaultButtons extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(createTab("Tab 1"), createTab("Tab 2"));
        primaryStage.setScene(new Scene(tabPane, 400, 400));
        primaryStage.show();
    }

    private Tab createTab(String text) {
        Tab tab = new Tab(text);
        Label label = new Label("This is "+text);
        Button ok = new Button("OK");

        ok.setOnAction(e -> System.out.println("OK pressed in "+text));

        VBox content = new VBox(5, label, ok);
        tab.setContent(content);

        ok.defaultButtonProperty().bind(tab.selectedProperty());

        return tab ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}