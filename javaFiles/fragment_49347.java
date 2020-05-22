import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainApp extends Application
{

    public static void main(String[] args)
    {
        Application.launch(MainApp.class);
    }

    @Override
    public void start(Stage primaryStage)
    {
        final ScrollPane root = new ScrollPane();
        root.setFitToWidth(true);

        Label lbl = new Label(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, "
                + "sed diam nonumy eirmod tempor invidunt ut labore et dolore "
                + "magna aliquyam erat, sed diam voluptua. At vero eos et "
                + "accusam et justo duo dolores et ea rebum.");
        lbl.setStyle("-fx-background-color: yellow");
        lbl.setWrapText(true);

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: blue");
        ap.getChildren().add(lbl);

        lbl.setTextAlignment(TextAlignment.JUSTIFY);
        lbl.setMaxHeight(Double.MAX_VALUE);

        VBox vBox = new VBox(ap);
        AnchorPane rootAP = new AnchorPane(vBox);
        root.setContent(rootAP);
        Scene scene = new Scene(root, 300, 250);

        lbl.prefWidthProperty().bind(scene.widthProperty());//This should bind the Label width to the Scene width

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}