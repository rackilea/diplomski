import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.stream.Collectors;

public class ImageDisplay extends Application {

    private List<Image> images;
    private Iterator<Image> imageIterator;

    @Override
    public void start(Stage stage) {
        images = Arrays.stream(IMAGE_LOCS)
                .map(Image::new)
                .collect(Collectors.toList());
        Collections.shuffle(images);
        imageIterator = images.iterator();
        ImageView imageView = new ImageView();

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            imageView.setImage(imageIterator.next());
                            System.out.println(
                                 "Displaying " + imageView.getImage().impl_getUrl()
                            );
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(images.size());
        timeline.setOnFinished(event -> {
            Collections.shuffle(images);
            imageIterator = images.iterator();
            timeline.playFromStart();
        });
        timeline.play();

        StackPane layout = new StackPane(imageView);
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // image license: linkware - backlink to http://www.fasticon.com
    private static final String[] IMAGE_LOCS = {
        "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Blue-Fish-icon.png",
        "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Red-Fish-icon.png",
        "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Yellow-Fish-icon.png",
        "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Green-Fish-icon.png"
    };
}