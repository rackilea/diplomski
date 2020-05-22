public class JavaApplication3 extends Application {

ButtonClass add;

@Override
public void start(Stage stage) {
    add = new ButtonClass();

    Pane root = new Pane();
    root.getChildren().add(add);

    Scene scene = new Scene(root, 150, 150);
    stage.setTitle("Testing Visual elements");
    stage.setScene(scene);
    stage.show();
    add.setOnAction((javafx.event.ActionEvent event) -> {
        System.out.println("Button pressed");
    });
}

public static void main(String[] args) {
    launch(args);
}