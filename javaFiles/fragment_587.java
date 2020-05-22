import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Example extends Application{

    ArrayList<Node> components = new ArrayList<Node>(); // arraylist to contain all components


    @Override
    public void start(Stage ps) throws Exception {
        FlowPane root = new FlowPane();

        for (int i=0; i<5; i++){

            HBox hb = new HBox();
            // set hb attributes

            Button b = new Button("Button" + i);
            // set b attributes

            // then add action listener
            b.setOnAction(e->{ 
                root.getChildren().remove(hb); // remove by Object reference
            });

            Label l = new Label("Label" + i);
            // set l attributes

            hb.getChildren().addAll(b,l);
            components.add(hb);
        }

        root.getChildren().addAll(components);

        Scene s = new Scene(root, 600,400);
        ps.setScene(s);

        ps.show();

    }

    public static void main(String[] args){
        launch(args);
    }

}