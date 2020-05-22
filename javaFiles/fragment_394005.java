import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

// display a captioned image in a viewport.
// click the image to get an expanded view.
public class LabelWithImage extends Application {
    private static final double IMAGE_WIDTH = 150;

    @Override
    public void start(Stage stage) {
        Image image = new Image(IMAGE_LOC);
        ImageView imageView = new ImageView(
                image
        );
        imageView.setViewport(
                new Rectangle2D(500, 320, 420, 300)
        );
        imageView.setFitWidth(IMAGE_WIDTH);
        imageView.setPreserveRatio(true);

        Label labeledImage = createCaptionedImage(
                imageView,
                "Village Home"
        );

        addGlowOnMouseOver(labeledImage);
        labeledImage.setOnMouseClicked(event -> {
            displayFullImage(stage, image);
        });

        VBox vbox = new VBox( // vbox just there to mimic question askers structure.
                labeledImage
        );
        vbox.setPadding(new Insets(10));

        ScrollPane scrollPane = makeScrollable(vbox);

        Scene scene = new Scene(
                scrollPane
        );

        stage.setScene(scene);
        stage.show();

        stage.setMaxWidth(stage.getWidth());
        stage.setMaxHeight(stage.getHeight());
    }

    private void displayFullImage(Stage stage, Image image) {
        Stage displayStage = new Stage();

        displayStage.initStyle(StageStyle.UTILITY);
        displayStage.initModality(Modality.APPLICATION_MODAL);
        displayStage.initOwner(stage);
        displayStage.setScene(
                new Scene(
                        new Group(
                                new ImageView(
                                        image
                                )
                        )
                )
        );
        displayStage.show();
    }

    private void addGlowOnMouseOver(Node node) {
        Glow glow = new Glow();
        DropShadow shadow = new DropShadow(20, Color.GOLD);
        glow.setInput(shadow);

        node.setOnMousePressed(event -> node.setEffect(null));
        node.setOnMouseEntered(event -> node.setEffect(glow));
        node.setOnMouseExited(event -> node.setEffect(null));
    }

    private ScrollPane makeScrollable(Node node) {
        ScrollPane scrollPane = new ScrollPane(node);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPannable(true);

        return scrollPane;
    }

    private Label createCaptionedImage(ImageView imageView, String caption) {
        Label labeledImage = new Label(caption);

        labeledImage.setFont(Font.font("Athelas", FontPosture.ITALIC, 20));
        labeledImage.setStyle("-fx-background-color: cornsilk");
        labeledImage.setPadding(new Insets(0, 0, 5, 0));
        labeledImage.setGraphic(
                imageView
        );
        labeledImage.setContentDisplay(ContentDisplay.TOP);

        return labeledImage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final String IMAGE_LOC =
            "http://www.imgion.com/images/01/beautiful-village-home.jpg";
            // image courtesy of http://www.imgion.com which provides
            // "free images on large topics to share with your friends and on your blogs."
}