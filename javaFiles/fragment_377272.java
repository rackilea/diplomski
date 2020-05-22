import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ShutdownTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button platformExit = new Button("Platform Exit");
        platformExit.setOnAction(e -> Platform.exit());
        Button systemExit = new Button("System Exit");
        systemExit.setOnAction(e -> System.exit(0));
        Button hang = new Button("Hang");
        hang.setOnAction(e -> {while(true);});
        HBox root = new HBox(5, platformExit, systemExit, hang);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutdown hook")));
        launch(args);
    }
}