import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class Popcorn extends Application {
    @Override
    public void start(Stage stage) {
        StackPane popupLayout = new StackPane(
                new Label(
                        "Clarke's third law\nAny sufficiently advanced technology is indistinguishable from magic."
                )
        );
        popupLayout.setStyle("-fx-opacity: 0.8; -fx-background-color: paleturquoise;");
        popupLayout.setPadding(new Insets(10));

        Popup popup = new Popup();
        popup.getContent().add(
                popupLayout
        );
        popupLayout.setOnMouseClicked(event -> popup.hide());

        ToggleButton showPopupButton = new ToggleButton("Show popup");

        showPopupButton.textProperty().bind(
                Bindings.when(showPopupButton.selectedProperty())
                        .then("Hide popup")
                        .otherwise("Show popup")
        );

        showPopupButton.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            if (isSelected) {
                showPopup(popup, showPopupButton);
            } else {
                popup.hide();
            }
        });

        popup.setOnShown(event -> showPopupButton.setSelected(true));
        popup.setOnHidden(event -> showPopupButton.setSelected(false));

        StackPane stageLayout = new StackPane(showPopupButton);
        stageLayout.setPadding(new Insets(10));
        stage.setScene(new Scene(stageLayout));
        stage.show();
    }

    private void showPopup(Popup popup, Control ownerNode) {
        Point2D anchorPoint = ownerNode.localToScreen(
                ownerNode.getWidth() / 2,
                ownerNode.getHeight()
        );

        popup.setAnchorLocation(
                PopupWindow.AnchorLocation.WINDOW_TOP_LEFT
        );

        popup.show(
                ownerNode,
                anchorPoint.getX(),
                anchorPoint.getY()
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}