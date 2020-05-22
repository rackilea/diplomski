import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WelcomeScene extends Scene
{
    public WelcomeScene(StackPane pane, double width, double height)
    {
        super(pane, width, height);
        try {
            setFill(Color.PINK);
            VBox vbox = new VBox();
            Label label = new Label("Welcome to the typing\n practice world");
            label.setFont(new Font("Cambria", 32));
            label.setStyle("-fx-text-alignment: center;");
            label.setTextFill(Color.RED);
            label.centerShapeProperty().bind(pane.centerShapeProperty());

            HBox hbox = new HBox();
            Button StartTypingBtn = new Button("Start typing");
            Button showFingurePosition = new Button("Check fingures prositions");
            Button checkImprovement = new Button("Check Improvement");
            hbox.setSpacing(10);
            hbox.setAlignment(Pos.CENTER);

            hbox.getChildren().add(StartTypingBtn);
            hbox.getChildren().add(showFingurePosition);
            hbox.getChildren().add(checkImprovement);

            vbox.getChildren().addAll(label, new ImageView(new Image(new FileInputStream("photos/hands_email.gif"))), hbox);
            vbox.setAlignment(Pos.CENTER);
            pane.getChildren().add(vbox);
            pane.setCenterShape(true);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}