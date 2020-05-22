import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SideDrawerAnimation extends Application {

    private static final int MENU_CONTENT_WIDTH = 230, MENU_MIN_WIDTH = 20, H = 400, W = 600;
    private static final double SPEED = 2;
    private VBox content;
    private Timeline openMenu, closeMenu;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Label label = new Label("->");
        label.setMinWidth(MENU_MIN_WIDTH);
        label.setPrefWidth(MENU_MIN_WIDTH);
        label.setStyle("-fx-text-fill: orange; -fx-background-color: black");

        content = new VBox();
        content.setPrefWidth(0);
        content.setStyle("-fx-background-color: purple");

        HBox menu = new HBox(content,label);
        menu.setAlignment(Pos.CENTER);
        menu.setMaxWidth(MENU_CONTENT_WIDTH+ MENU_MIN_WIDTH);
        menu.prefWidthProperty().bind(content.prefWidthProperty().add(label.prefWidthProperty()));
        menu.setStyle("-fx-background-color: yellow");

        BorderPane mainContent = new BorderPane(new Label("CENTER"),new Label("TOP"),new Label("RIGHT"),
                new Label("BOTTOM"),new Label("LEFT"));
        mainContent.setStyle("-fx-background-color: cyan");

        openMenu = new Timeline(
                new KeyFrame(Duration.millis(SPEED), event -> setMenuContentPrefSize(openMenu,1))
         );
        openMenu.setCycleCount(Timeline.INDEFINITE);

        closeMenu = new Timeline(
                new KeyFrame(Duration.millis(SPEED), event -> setMenuContentPrefSize(closeMenu, -1))
        );
        closeMenu.setCycleCount(Timeline.INDEFINITE);

        menu.setOnMouseEntered(evt -> {
            closeMenu.stop(); openMenu.play();
        });
        menu.setOnMouseExited(evt -> {
            openMenu.stop(); closeMenu.play();
        });

        HBox root = new HBox(menu, mainContent);
        HBox.setHgrow(mainContent, Priority.ALWAYS);

        Scene scene = new Scene(root, W, H);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setMenuContentPrefSize(Timeline timeline, int i) {

        double width = content.getPrefWidth();

        if(width > MENU_CONTENT_WIDTH){
            timeline.stop();
            content.setPrefWidth(MENU_CONTENT_WIDTH);

        } else if (width < 0){
            timeline.stop();
            content.setPrefWidth(0);
        } else {
            content.setPrefWidth(width +i);
        }
    }

    public static void main(String[] args) {
        launch(null);
    }
}