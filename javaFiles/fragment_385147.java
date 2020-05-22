import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LayoutTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        grid.getRowConstraints().add(row1);

        ColumnConstraints colConstraints = new ColumnConstraints();
        colConstraints.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().add(colConstraints);

        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 400, 300,Color.WHITESMOKE);

        //Create welcome message and add it to grid, and align it to the center
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setStyle("-fx-font-size:48;");
        grid.add(sceneTitle,0,0);

        //Create buttons and fix their widths
        Button newBtn = new Button("Create New Project");
        Button loadBtn = new Button("Load Existing Project");
        newBtn.setMaxWidth(150);
        loadBtn.setMaxWidth(150);

        grid.add(newBtn, 0, 1);

        GridPane.setMargin(loadBtn, new Insets(5, 0, 5, 0));
        grid.add(loadBtn, 0, 2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}