import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DefaultFocusDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        Scene sc = new Scene(root, 500, 500);
        primaryStage.setScene(sc);
        primaryStage.show();


        ToggleButton btn1 = new ToggleButton("Button 1");
        ToggleButton btn2 = new ToggleButton("Button 2");
        ToggleButton btn3 = new ToggleButton("Button 3");
        ToggleButton btn4 = new ToggleButton("Button 4");

        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(btn1, btn2);

        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(btn3, btn4);

        root.getChildren().addAll(hb1, hb2);

        hb1.requestFocus();
    }
}