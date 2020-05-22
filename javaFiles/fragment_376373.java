import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Test {

    private Button btn;
    private Pane view ;

    public Test(String text) {
        Logger.getLogger("Test").log(Level.INFO, "Created Test instance");

        view = new StackPane();
        btn = new Button();
        btn.setText(text);
        view.getChildren().add(btn);

    }   

    public Parent getView() {
        return view ;
    }

    public void setText(String newText){
        btn.setText(newText);
    }
}