package application.prototypes.custom.resizableborderpane;

import java.io.IOException;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ResizeableBorderPane extends BorderPane {  

    @FXML
    private BorderPane root;

    @FXML
    private AnchorPane topAnchor;

    @FXML
    private AnchorPane leftAnchor;

    @FXML
    private AnchorPane centerAnchor;

    @FXML
    private AnchorPane rightAnchor;

    @FXML
    private AnchorPane bottomAnchor;

    @FXML
    private JFXHamburger hamburger;

    private Stage stage;

    public ResizeableBorderPane(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/application/prototypes/custom/resizableborderpane/ResizableBorderPaneView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        root.setPrefWidth(1000);
        root.setPrefHeight(600);
    }

    @FXML
    public void initialize() {

        leftAnchor.setPrefWidth(200);
        leftAnchor.setTranslateX(-150);
        setMargin(leftAnchor, new Insets(0, leftAnchor.translateXProperty().doubleValue(), 0, 0));

        topAnchor.setPrefHeight(50);
        bottomAnchor.setPrefHeight(50);
        rightAnchor.setPrefWidth(50);

        final TranslateTransition translateLeftAnchor =
                new TranslateTransition(Duration.millis(500), leftAnchor);

        HamburgerBasicCloseTransition burgerTask = new HamburgerBasicCloseTransition(hamburger);
        burgerTask.setRate(-1);

        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{

            if (burgerTask.getRate() == -1){
                burgerTask.setRate(burgerTask.getRate()*-1);
                burgerTask.play();

                translateLeftAnchor.setFromX(-200 + 50);
                translateLeftAnchor.setToX(0);

                translateLeftAnchor.play();

            } else {

                burgerTask.setRate(burgerTask.getRate()*-1);
                burgerTask.play();

                translateLeftAnchor.setFromX(0);
                translateLeftAnchor.setToX(-200 + 50);

                translateLeftAnchor.play();
            }           
        });

        leftAnchor.translateXProperty().addListener( e -> {

            setMargin(leftAnchor, new Insets(0, leftAnchor.translateXProperty().doubleValue(), 0, 0));
        });
    }

    // =========== GETTERS AND SETTERS ===========

    public Stage getStage(){
        return (Stage) root.getScene().getWindow();
    }

    public BorderPane getRoot() {
        return root;
    }

    public AnchorPane getTopAnchor() {
        return topAnchor;
    }

    public AnchorPane getLeftAnchor() {
        return leftAnchor;
    }

    public AnchorPane getCenterAnchor() {
        return centerAnchor;
    }

    public AnchorPane getRightAnchor() {
        return rightAnchor;
    }

    public AnchorPane getBottomAnchor() {
        return bottomAnchor;
    }
}