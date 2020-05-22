package sceneswitcher;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        ViewModel viewModel = new ViewModel();

        FXMLLoader aLoader = new FXMLLoader(getClass().getResource("A.fxml"));
        Parent a = aLoader.load();
        AController aController = aLoader.getController();
        aController.setViewModel(viewModel);

        FXMLLoader bLoader = new FXMLLoader(getClass().getResource("B.fxml"));
        Parent b = bLoader.load();
        BController bController = bLoader.getController();
        bController.setViewModel(viewModel);

        Scene scene = new Scene(a, 400, 400);

        scene.rootProperty().bind(Bindings.createObjectBinding(() -> {
            if (viewModel.getCurrentView() == ViewModel.View.A) {
                return a ;
            } else if (viewModel.getCurrentView() == ViewModel.View.B) {
                return b ;
            } else {
                return null ;
            }
        }, viewModel.currentViewProperty()));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}