import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextFieldRegexExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        Color[] colors = new Color[] {Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.BLUE, Color.CYAN, Color.PURPLE};

        TextField textField = new TextField();
        Pattern pattern = Pattern.compile("(\\^(?<colorIndex>\\d))?(?<text>[^(\\^\\d)]+)");

        TextFlow textFlow = new TextFlow();

        textField.textProperty().addListener((obs, oldValue, newValue) -> {
            Matcher matcher = pattern.matcher(newValue);

            textFlow.getChildren().clear();

            while(matcher.find()) {
                String color = matcher.group("colorIndex");
                String text = matcher.group("text");
                Text t = new Text(text+" ");
                if (color != null && color.matches("\\d+")) {
                    int colIndex = Integer.parseInt(color);
                    if (colIndex >= 0 && colIndex < colors.length) {
                        t.setFill(colors[colIndex]);
                    }
                }
                textFlow.getChildren().add(t);
            }
        });

        VBox root = new VBox(5, textField, textFlow);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}