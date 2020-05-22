import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Pane playfield;

    List<Walker> allWalkers = new ArrayList<>();

    PVector mouse = new PVector(0,0,0);

    @Override
    public void start(Stage primaryStage) {

        // create containers
        BorderPane root = new BorderPane();

        StackPane layerPane = new StackPane();

        // playfield for our walkers
        playfield = new Pane();

        layerPane.getChildren().addAll(playfield);

        root.setCenter(layerPane);

        Scene scene = new Scene(root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        // add 1 walker
        addWalker();

        // capture mouse position
        scene.addEventFilter(MouseEvent.ANY, e -> {
            mouse.set(e.getX(), e.getY(), 0);
        });

        // process all walkers
        AnimationTimer loop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                // move
                allWalkers.forEach((walker) -> walker.step(mouse));

                // check border
                allWalkers.forEach(Walker::checkBoundaries);

                // update in fx scene
                allWalkers.forEach(Walker::display);

            }
        };

        loop.start();

    }

    /**
     * Add single walker to list of walkers and to the playfield
     */
    private void addWalker() {

        Walker walker = new Walker();

        allWalkers.add(walker);

        playfield.getChildren().add(walker);

    }

    public static void main(String[] args) {
        launch(args);
    }
}