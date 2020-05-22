package ic.ac.uk.relationshipvisualiser.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class tmpTest extends Application {

    public static void main(String[] args) {
        System.out.println("Start tmpTest");
        launch(args);
        System.out.println("Start tmpTest");
    }

    final Group m_root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
        String sample_fxml = 
                "<?import javafx.scene.control.Label?>" +
                "<?import javafx.scene.Group?>" +
                "<Group xmlns:fx=\"http://javafx.com/fxml\">" +
                "       <Label fx:id=\"Name\" style=\"-fx-font-weight: bold;\" alignment=\"CENTER\">It worked</Label>" +        
                "</Group>";

        InputStream stream = new ByteArrayInputStream(sample_fxml.getBytes("UTF-8"));
        FXMLLoader l = new FXMLLoader();

        Group mG = (Group) l.load(stream);

        m_root.getChildren().add(mG);

        primaryStage.setScene(new Scene(m_root));

        primaryStage.show();

    }

}