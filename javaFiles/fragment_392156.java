import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class JSTEst2 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                //if the page is loaded

                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("app", this);
                engine.executeScript("document.addEventListener('click', function(event) { alert(event.target.id); app.getCallBack(event.target.id);}, false);");
            }
        });

        engine.load("<my_url>");
        engine.setOnAlert(event -> showAlert(event.getData()));
        engine.setConfirmHandler(message -> showConfirm(message));

        VBox root = new VBox();

        root.getChildren().add(webView);

        root.setStyle("-fx-padding: 10;" +

                "-fx-border-style: solid inside;" +

                "-fx-border-width: 2;" +

                "-fx-border-insets: 5;" +

                "-fx-border-radius: 5;" +

                "-fx-border-color: blue;");

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


        private void showAlert(String message) {
            Dialog<Void> alert = new Dialog<>();
            alert.getDialogPane().setContentText(message);
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();
        }

        private boolean showConfirm(String message) {
            Dialog<ButtonType> confirm = new Dialog<>();
            confirm.getDialogPane().setContentText(message);
            confirm.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
            boolean result = confirm.showAndWait().filter(ButtonType.YES::equals).isPresent();

            // for debugging:
            System.out.println(result);

            return result ;
        }

        public void getCallBack(String data) {
            System.out.println("---->" + data);
        }

    }

}