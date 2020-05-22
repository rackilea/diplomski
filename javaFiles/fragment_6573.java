public class JavaFXApplication extends Application {

public static Stage primaryStage;

@Override
public void start(Stage stage) {

    stage.setTitle("Hello World!");
    stage.setScene(scene);
    stage.show();

    primaryStage = stage;
}

public static void main(String[] args) {
    launch(args);
}
}