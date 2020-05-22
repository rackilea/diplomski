import java.util.Random;
import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxTest extends Application {

    public  static final String ALFA_BET = "ABCDEFGHIKLMNOPQRSTUXYZ";
    private final Random rnd = new Random();
    private TilePane main;

    @Override
    public void start(Stage primaryStage)throws Exception{

        main = new TilePane(); //use tile pane: all tiles have same size
        main.setPrefColumns(ALFA_BET.length());
        main.setOrientation(Orientation.HORIZONTAL);
        main.setHgap(1);  main.setVgap(10); //vertical and horizontal space
        makeSlots();

        Button add = new Button("Spin");
        add.setOnAction(e -> spin());

        BorderPane root = new BorderPane(main);
        root.setBottom(add);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //primaryStage.sizeToScene();
        primaryStage.show();
    }

    private void spin() {
        for(Node node : main.getChildren()){
            ((Slot)node).spin();
        }
    }

    private void makeSlots() {
        for (int i=0; i< ALFA_BET.length(); i++){
            main.getChildren().add(new Slot());
        }
    }

    public static void main(String[] args) {
        launch(null);
    }

    class Slot extends StackPane{

        private final Text text;
        private static final String format = "%1S";
        private static final double WIDTH = 30, TRANS_SIZE = 30;
        private SequentialTransition animation;

        Slot(){
            text = new Text();
            setRandomText();
            getChildren().add(text);
            setPrefWidth(WIDTH);
            //better apply using css
            setStyle("-fx-padding: 5;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: blue;"+
                    //all letters have the same width
                    "-fx-font-family: 'monospaced';");
            initializeAnimation();
        }

        //define animation to be applied to text
        private void initializeAnimation() {
            TranslateTransition t1 = new TranslateTransition();
            t1.setDuration(Duration.millis(1));
            t1.setNode(text);
            t1.setFromX(0);
            t1.setFromY(0);
            t1.setToX(0);
            t1.setToY(TRANS_SIZE);
            t1.setInterpolator(Interpolator.LINEAR);

            TranslateTransition t2 = new TranslateTransition();
            t2.setDuration(Duration.millis(300));
            t2.setNode(text);
            t2.setFromX(0);
            t2.setFromY(-TRANS_SIZE);
            t2.setToX(0);
            t2.setToY(TRANS_SIZE);
            t2.setInterpolator(Interpolator.LINEAR);

            TranslateTransition t3 = new TranslateTransition();
            t3.setDuration(Duration.millis(1));
            t3.setNode(text);
            t3.setFromX(0);
            t3.setFromY(TRANS_SIZE);
            t3.setToX(0);
            t3.setToY(0);
            t3.setInterpolator(Interpolator.LINEAR);
            //to play animations one by one
            animation = new SequentialTransition(t1, t2, t3);
        }

        void spin() {
            animation.play(); //animate
            animation.setOnFinished(e-> setRandomText()); //change letter whaen animation ends
        }
        void setRandomText(){
            char letter =  ALFA_BET.charAt(rnd.nextInt(ALFA_BET.length()));
            setText(letter );
        }

        void setText(char c){
            text.setText(String.format(format, c) );
        }
    }
}