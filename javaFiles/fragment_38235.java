import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ClickOnScrollingImage extends Application {

    private static final String IMAGE_URL = "https://www.nasa.gov/sites/default/files/styles/full_width_feature/public/thumbnails/image/crop_p_color2_enhanced_release_small.png?itok=5BtHNey_" ;


    @Override
    public void start(Stage primaryStage) {
        ScrollPane scroller = new ScrollPane();
        ImageView imageView = new ImageView(IMAGE_URL);
        scroller.setContent(imageView);

        // the following line allows detection of clicks on transparent
        // parts of the image:
        imageView.setPickOnBounds(true);

        imageView.setOnMouseClicked(e -> {
            System.out.println("["+e.getX()+", "+e.getY()+"]");
        });
        Scene scene = new Scene(scroller, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}