import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane flow = new FlowPane();
        flow.setStyle("-fx-border-color: red");

        addPanes(flow, 16);

        ScrollPane scroll = new ScrollPane(flow);
        scroll.setStyle("-fx-border-color: green");

        // Apparently this cause the issue here.
        // scroll.setFitToHeight(true);
        // scroll.setFitToWidth(true);


        // Instead just make the flow pane take the dimensions of the ScrollPane
        // the -5 is to not show the Bars when both of panes have the same dimensions  
        flow.prefWidthProperty().bind(Bindings.add(-5, scroll.widthProperty()));
        flow.prefHeightProperty().bind(Bindings.add(-5, scroll.heightProperty()));

        Scene scene = new Scene(scroll, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void addPanes(FlowPane root, int panes) {
        for (int i = 0; i < panes; i++) {
            HBox filler = new HBox();
            filler.setStyle("-fx-border-color: black");
            filler.setPrefSize(100, 100);
            root.getChildren().add(filler);
        }
    }
}