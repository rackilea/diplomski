import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomMinimize extends Application {
    @Override
    public void start(Stage stage) {        
        Image imgWhite = new Image(getClass().getResourceAsStream("imgWhite.png"));  //your image here
        Image imgGreen = new Image(getClass().getResourceAsStream("imgGreen.png"));  //your hover image here
        MinimizeButton btnMinimize = new MinimizeButton(imgWhite, imgGreen, stage);
        btnMinimize.setStyle("-fx-background-color: black;");
        btnMinimize.setPrefSize(50, 50);
        Button btnExit = new Button("X");
        btnExit.setMinSize(50,50);
        btnExit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        btnExit.setStyle("-fx-background-color: black;");
        HBox hBox = new HBox();
        hBox.setSpacing(2);
        hBox.getChildren().addAll(btnMinimize, btnExit);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(hBox);
        AnchorPane.setRightAnchor(hBox, 5.0);
        AnchorPane.setTopAnchor(hBox, 5.0);

        Scene scene = new Scene(anchorPane);
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}