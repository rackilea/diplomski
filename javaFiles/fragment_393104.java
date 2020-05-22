import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatingIconMenu extends Application {

    private BorderPane root ;

    @Override
    public void start(Stage primaryStage) {
        HBox menu = new HBox(10);
        BorderPane.setMargin(menu, new Insets(10));
        menu.setAlignment(Pos.CENTER);

        for (int i = 1; i <= 4 ; i++) {
            Option opt = new Option("Choice "+i);
            opt.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {

                Node view = opt.getView();
                Bounds b = view.getBoundsInParent();

                Rectangle clip = new Rectangle();
                Timeline timeline = new Timeline();
                Duration duration = Duration.seconds(0.66);

                if (isNowSelected) {

                    clip.setWidth(menu.getWidth());
                    clip.setHeight(menu.getHeight());

                    timeline.getKeyFrames().add(new KeyFrame(duration, 
                        new KeyValue(clip.xProperty(), b.getMinX()),
                        new KeyValue(clip.yProperty(), b.getMinY()),
                        new KeyValue(clip.widthProperty(), b.getWidth()),
                        new KeyValue(clip.heightProperty(), b.getHeight()), 
                        new KeyValue(clip.arcWidthProperty(), Math.min(b.getWidth(), b.getHeight())),
                        new KeyValue(clip.arcHeightProperty(), Math.min(b.getWidth(), b.getHeight())),
                        new KeyValue(menu.translateXProperty(), menu.getWidth() - b.getMaxX())));

                    timeline.setOnFinished(e -> showPage(opt));

                } else {

                    clip.setWidth(b.getWidth());
                    clip.setHeight(b.getHeight());
                    clip.setX(b.getMinX());
                    clip.setY(b.getMinY());
                    clip.setArcWidth(Math.min(b.getWidth(), b.getHeight()));
                    clip.setArcHeight(Math.min(b.getWidth(), b.getHeight()));

                    timeline.getKeyFrames().add(new KeyFrame(duration,
                        new KeyValue(clip.xProperty(), 0),
                        new KeyValue(clip.yProperty(), 0),
                        new KeyValue(clip.widthProperty(), menu.getWidth()),
                        new KeyValue(clip.heightProperty(), menu.getHeight()),
                        new KeyValue(clip.arcHeightProperty(), 0),
                        new KeyValue(clip.arcWidthProperty(), 0),
                        new KeyValue(menu.translateXProperty(), 0)));

                    timeline.setOnFinished(e -> showHome());
                }
                menu.setClip(clip);

                timeline.play();
            });
            menu.getChildren().add(opt.getView());
        }

        root = new BorderPane();
        showHome();
        root.setTop(menu);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    private void showPage(Option option) {

        Label label = new Label(option.getOptionText());
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 48));
        root.setCenter(label);
    }

    private void showHome() {
        Label label = new Label("Home");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 48));
        root.setCenter(label);
    }

    public static class Option {

        private BooleanProperty selected = new SimpleBooleanProperty();

        private final String optionText ;
        private final Label view ;

        public Option(String optionText) {
            this.optionText = optionText ;
            this.view = new Label(optionText);
            view.setAlignment(Pos.CENTER);
            view.setWrapText(true);
            view.setPrefSize(80, 80);
            view.setStyle("-fx-background-color: -fx-background; -fx-background: "+randomColor()+";"); 
            view.setOnMouseClicked(e -> setSelected(!isSelected()));
        }

        public Node getView() {
            return view ;
        }

        public String getOptionText() {
            return optionText ;
        }

        private String randomColor() {
            Random rng = new Random();
            int r = rng.nextInt(256);
            int g = rng.nextInt(256);
            int b = rng.nextInt(256);
            return String.format("#%02x%02x%02x", r, g, b);
        }

        public final BooleanProperty selectedProperty() {
            return this.selected;
        }


        public final boolean isSelected() {
            return this.selectedProperty().get();
        }


        public final void setSelected(final boolean selected) {
            this.selectedProperty().set(selected);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}