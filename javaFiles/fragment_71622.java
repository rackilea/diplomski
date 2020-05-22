import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;

 public class ComboMain extends Application {
      @Override
      public void start(Stage primaryStage) throws Exception{
          Parent root = FXMLLoader.load(getClass().getResource("combo.fxml"));
          primaryStage.setTitle("Combo");
          primaryStage.setScene(new Scene(root));
          primaryStage.show();
      }

      public static void main(String[] args) {
          launch(args);
      }
 }