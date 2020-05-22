import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Video extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        BorderPane videoPane = new BorderPane();
        Scene mainScene = new Scene(root, 1280, 800);

        MenuBar video_menuBar = new MenuBar();
        Menu video_menuFile = new Menu("File");

        MediaView video_mv = new MediaView();

        MenuItem video_open = new MenuItem("Open File...");
        video_open.setOnAction(t -> {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                Media video_source = new Media(file.toURI().toString());
                MediaPlayer video_mp = new MediaPlayer(video_source);
                video_mv.setMediaPlayer(video_mp);
                video_mp.play();
            }
        });
        video_menuFile.getItems().addAll(video_open);

        Menu video_menuEdit = new Menu("Edit");

        Menu video_menuView = new Menu("View");
        MenuItem mainPage = new MenuItem("Main Menu");
        mainPage.setOnAction(e -> primaryStage.setScene(mainScene));
        video_menuView.getItems().add(mainPage);

        video_menuBar.getMenus().addAll(video_menuFile, video_menuEdit, video_menuView);
        video_menuBar.prefWidthProperty().bind(videoPane.widthProperty());

        videoPane.setTop(video_menuBar);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(new Rectangle(1000, 600, Color.BLACK), video_mv);
        videoPane.setCenter(stack);

        root.getChildren().add(videoPane);

        primaryStage.setScene(mainScene);

        primaryStage.setTitle("Media Player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}