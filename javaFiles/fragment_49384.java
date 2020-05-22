import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private final int CANVAS_WIDTH = 1600;
    private final int CANVAS_HEIGHT = 750;
    private final int MENU_HEIGHT = 150;

    private GraphicsContext graphics;
    private GUI gui;

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();
        gui = new GUI(CANVAS_WIDTH, CANVAS_HEIGHT, MENU_HEIGHT);
        gui.setup();

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);

        graphics = canvas.getGraphicsContext2D();

        clearCanvas();


        root.setCenter(canvas);
        root.setBottom(gui.getRoot());



        primaryStage.setTitle("FireworkSim by Cedric Martens");
        primaryStage.setScene(new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT + MENU_HEIGHT, Color.rgb(137, 182, 255)));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void clearCanvas()
    {
        graphics.setFill(Color.BLACK);
        graphics.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

    }
}