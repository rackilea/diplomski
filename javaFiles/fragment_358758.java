import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @see https://stackoverflow.com/a/37935114/230513
 */
public class BorderTest extends Application {

    private static final Border black = new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(2)));
    private static final Border red = new Border(new BorderStroke(Color.RED,
        BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(2)));
    private static final Border blue = new Border(new BorderStroke(Color.BLUE,
        BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(2)));
    private static final Color yellow = Color.YELLOW.deriveColor(0, .9, 1, 1);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");

        GridPane root = new GridPane();
        root.setPadding(new Insets(16));
        root.setVgap(16);
        root.setBorder(black);
        root.setBackground(new Background(new BackgroundFill(
            Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        BorderPane top = new BorderPane();
        top.setPadding(new Insets(16));
        top.setBorder(red);
        top.setLeft(createLabel("Label 1", yellow, 16));
        Label topCenter = createLabel("Label 2", yellow, 64);
        topCenter.setContentDisplay(ContentDisplay.CENTER);
        BorderPane.setMargin(topCenter, new Insets(16));
        top.setCenter(topCenter);
        top.setRight(createLabel("Label 3", yellow, 16));
        root.add(top, 0, 0);

        BorderPane bot = new BorderPane();
        bot.setPadding(new Insets(16));
        bot.setBorder(blue);
        bot.setCenter(createLabel("Label 4", Color.GREEN, 24));
        root.add(bot, 0, 1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createLabel(String text, Color color, int size) {
        Rectangle r = new Rectangle(3 * size, 2 * size);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(color);
        r.setStrokeWidth(3);
        Label l = new Label(text, r);
        l.setContentDisplay(ContentDisplay.TOP);
        l.setTextFill(color);
        l.setFont(new Font(16));
        return l;
    }

    public static void main(String[] args) {
        launch(args);
    }
}