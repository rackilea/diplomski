import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.control.RadioButton;
    import javafx.scene.control.ToggleGroup;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.StackPane;
    import javafx.scene.layout.VBox;
    import javafx.scene.paint.Color;
    import javafx.scene.shape.Rectangle;
    import javafx.stage.Stage;

    public class RectangleApp extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {

            Rectangle rectangle = new Rectangle(100, 100, Color.BLACK);
            StackPane stackPane = new StackPane(rectangle);

            RadioButton redButton = new RadioButton("Red");
            RadioButton blueButton = new RadioButton("Blue");

            //It's not good style to get the color using valueOf() but I'm staying in context of the sample 
            redButton.setOnAction(event -> rectangle.setFill(Color.valueOf("red")));
            blueButton.setOnAction(event -> rectangle.setFill(Color.valueOf("blue")));

            ToggleGroup toggleGroup = new ToggleGroup();
            toggleGroup.getToggles().setAll(redButton, blueButton);

            HBox hBox = new HBox(redButton, blueButton);

            VBox vBox = new VBox(hBox, stackPane);
            Scene scene = new Scene(vBox, 400, 400);
            stage.setScene(scene);
            stage.show();
        }
    }