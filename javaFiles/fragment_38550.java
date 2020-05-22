import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxMain extends Application {

    private static final int COLS = 5, ROWS = 5;
    private Tile flip1, flip2;
    private boolean busy = false;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(makeGrid()));
        primaryStage.show();
    }

    private Pane makeGrid() {

        GridPane grid = new GridPane();
        grid.setHgap(5); grid.setVgap(5);
        grid.setPadding(new Insets(5));

        for(int rowIndex = 0; rowIndex < ROWS ; rowIndex++) {
            //an array to hold buttons of one row
            Node[] nodes = new Node[COLS];
            for(int colIndex = 0; colIndex < COLS ; colIndex++) {
                Tile tile=  new Tile(String.valueOf(rowIndex + colIndex));
                tile.setOnMouseClicked(e->handleTiles(tile));
                nodes[colIndex]= tile;
            }
            grid.addRow(rowIndex, nodes);
        }
        return grid;
    }

    public void handleTiles(Tile t){

        if(busy) return; //ignore new clicks until previous ones were processed
        busy = true;

        if (flip1 == null) {
            flip1 = t;
            flip1.toggleTile();
            busy = false;
            return;
        }else {

            flip2 = t;
            flip2.toggleTile();
            //set delay to 0 if values match
            double duration = flip1.getValue().equals(flip2.getValue()) ? 0 : 2 ;

            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(duration));
            pauseTransition.setOnFinished(e->{

                if(!flip1.getValue().equals(flip2.getValue())) {
                    flip1.toggleTile();
                    flip2.toggleTile();
                }
                flip1 = null;
                flip2 = null;
                busy = false;
            });
            pauseTransition.play();
        }
    }

    public static void main(final String[] args) {
        launch(args);
    }
}

class Tile extends StackPane {

    private final Text text;

    Tile(String value) {
        text = new Text(value);
        text.setFont(Font.font(30));
        text.setVisible(false);
        setPrefSize(50,50);
        setAlignment(Pos.CENTER);
        setStyle("-fx-border-color: black");
        getChildren().add(text);
    }

    public void toggleTile(){
        text.setVisible( ! text.isVisible());
    }

    public String getValue(){
        return text.getText();
    }
}