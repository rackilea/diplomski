import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Test {

    private Pane view ;

    public Test(DataModel data) {
        Logger.getLogger("Test").log(Level.INFO, "Created Test instance");

        view = new StackPane();
        Button btn = new Button();
        btn.textProperty().bind(data.textProperty());
        view.getChildren().add(btn);

    }   

    public Parent getView() {
        return view ;
    }
}