import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddingApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AddingModel model = new AddingModel();
        AddingController controller = new AddingController(model);

        FXMLLoader loader = new FXMLLoader(AddingController.class.getResource("ValueTotaler.fxml"));
        loader.setControllerFactory(type -> {
            if (type == AddingController.class) {
                return controller ;
            } else {
                throw new IllegalArgumentException("Unexpected controller type: "+type);
            }
        });
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        AddingCLI cli = new AddingCLI(model);
        Thread cliThread = new Thread(cli::processCommandLine);
        cliThread.setDaemon(true);
        cliThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}