import java.util.Collection;
import java.util.Objects;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;

import javafx.stage.Stage;

public class OneTouchExpandable
extends Application {

    /**
     * Node properties key whose value is the saved divider position
     * just before user's one-touch-expand action is executed.
     */
    private static final Object ORIGINAL_POSITION = 
        OneTouchExpandable.class.getName() + ".originalPosition";

    /**
     * Percentage of divider thickness which one-touch button takes up,
     * as a value from 0.0 to 1.0.
     */
    private static final double ARROW_THICKNESS = 0.60;

    /**
     * Delta for comparing divider position (a double) with the min and max
     * divider values, which in practice do not reach 0.0 or 1.0.
     */
    private static final double END_TOLERANCE = 0.01;

    /**
     * Adds one-touch-expand buttons to a SplitPane's first divider.
     */
    public static void addOneTouchExpansion(SplitPane pane) {

        StackPane divider = (StackPane) pane.lookup(".split-pane-divider");
        Objects.requireNonNull(divider, "SplitPane's divider not present!"
            + " (you probably need to call this method from within"
            + " Platform.runLater)");

        DoubleBinding dividerPosition = Bindings.selectDouble(
            Bindings.valueAt(pane.getDividers(), 0), "position");

        Button colorSource = new Button();
        ColorAdjust disabledColor = new ColorAdjust(0, 0, 0.5, 0);

        BorderPane expander = new BorderPane();
        if (pane.getOrientation() == Orientation.VERTICAL) {
            DoubleExpression scale =
                divider.heightProperty().multiply(ARROW_THICKNESS);
            DoubleExpression indent =
                divider.heightProperty().multiply((1 - ARROW_THICKNESS) / 2);

            Polygon upArrow = new Polygon(1, 0, 0, 1, 2, 1);
            upArrow.setCursor(Cursor.DEFAULT);
            upArrow.fillProperty().bind(colorSource.textFillProperty());
            upArrow.scaleXProperty().bind(scale);
            upArrow.scaleYProperty().bind(scale);
            upArrow.disableProperty().bind(
                dividerPosition.isEqualTo(0, END_TOLERANCE));
            upArrow.effectProperty().bind(
                Bindings.when(upArrow.disabledProperty())
                    .then(disabledColor).otherwise((ColorAdjust) null));
            upArrow.setOnMouseClicked(e -> setDividerPosition(pane, 0));

            Polygon downArrow = new Polygon(1, 1, 0, 0, 2, 0);
            downArrow.setCursor(Cursor.DEFAULT);
            downArrow.fillProperty().bind(colorSource.textFillProperty());
            downArrow.scaleXProperty().bind(scale);
            downArrow.scaleYProperty().bind(scale);
            downArrow.translateXProperty().bind(scale.multiply(2).add(3));
            downArrow.disableProperty().bind(
                dividerPosition.isEqualTo(1, END_TOLERANCE));
            downArrow.effectProperty().bind(
                Bindings.when(downArrow.disabledProperty())
                    .then(disabledColor).otherwise((ColorAdjust) null));
            downArrow.setOnMouseClicked(e -> setDividerPosition(pane, 1));

            Group expandButtonsPane = new Group(upArrow, downArrow);
            expandButtonsPane.translateYProperty().bind(indent);

            expander.setLeft(expandButtonsPane);
        } else {
            DoubleExpression scale =
                divider.widthProperty().multiply(ARROW_THICKNESS);
            DoubleExpression indent =
                divider.widthProperty().multiply((1 - ARROW_THICKNESS) / 2);

            Polygon leftArrow = new Polygon(0, 1, 1, 0, 1, 2);
            leftArrow.setCursor(Cursor.DEFAULT);
            leftArrow.fillProperty().bind(colorSource.textFillProperty());
            leftArrow.scaleXProperty().bind(scale);
            leftArrow.scaleYProperty().bind(scale);
            leftArrow.disableProperty().bind(
                dividerPosition.isEqualTo(0, END_TOLERANCE));
            leftArrow.effectProperty().bind(
                Bindings.when(leftArrow.disabledProperty())
                    .then(disabledColor).otherwise((ColorAdjust) null));
            leftArrow.setOnMouseClicked(e -> setDividerPosition(pane, 0));

            Polygon rightArrow = new Polygon(1, 1, 0, 0, 0, 2);
            rightArrow.setCursor(Cursor.DEFAULT);
            rightArrow.fillProperty().bind(colorSource.textFillProperty());
            rightArrow.scaleXProperty().bind(scale);
            rightArrow.scaleYProperty().bind(scale);
            rightArrow.translateYProperty().bind(scale.multiply(2).add(3));
            rightArrow.disableProperty().bind(
                dividerPosition.isEqualTo(1, END_TOLERANCE));
            rightArrow.effectProperty().bind(
                Bindings.when(rightArrow.disabledProperty())
                    .then(disabledColor).otherwise((ColorAdjust) null));
            rightArrow.setOnMouseClicked(e -> setDividerPosition(pane, 1));

            Group expandButtonsPane = new Group(leftArrow, rightArrow);
            expandButtonsPane.translateXProperty().bind(indent);

            expander.setTop(expandButtonsPane);
        }

        divider.getChildren().add(expander);
    }

    /**
     * Checks whether double values are nearly equal.
     */
    private static boolean isNearly(double value,
                                    double target) {
        return (Math.abs(target - value) < END_TOLERANCE);
    }

    /**
     * Executes a one-touch expansion/contraction.
     *
     * @param pane SplitPane to perform expansion on
     * @param end farthest divider position in direction of expansion,
     *            either 0 or 1
     */
    private static void setDividerPosition(SplitPane pane,
                                           double end) {
        double oldPosition = pane.getDividers().get(0).getPosition();
        double start = 1 - end;
        if (isNearly(oldPosition, start)) {
            Object savedPosition = pane.getProperties().get(ORIGINAL_POSITION);
            if (savedPosition instanceof Number) {
                pane.setDividerPosition(0,
                    ((Number) savedPosition).doubleValue());
            } else {
                pane.setDividerPosition(0, 0.5);
            }
        } else if (!isNearly(oldPosition, end)) {
            pane.getProperties().put(ORIGINAL_POSITION, oldPosition);
            pane.setDividerPosition(0, end);
        }
    }

    /**
     * Displays test window.  Invoke application with 'vertical' as first
     * command-line argument to use a vertical SplitPane.
     */
    @Override
    public void start(Stage stage) {
        Node child1 = createChild("Child 1");
        Node child2 = createChild("Child 2");

        SplitPane pane = new SplitPane(child1, child2);

        Collection<String> params = getParameters().getUnnamed();
        if (params.stream().anyMatch(s -> s.matches("[Vv].*"))) {
            pane.setOrientation(Orientation.VERTICAL);
        }

        Platform.runLater(() -> addOneTouchExpansion(pane));

        stage.setTitle("One-Touch Expandable Demo");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    /**
     * Creates a SplitPane child for test window.
     *
     * @param text text to show in node
     */
    private static Node createChild(String text) {
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);

        label.setMinWidth(0);
        label.setMinHeight(0);
        label.setMaxWidth(10000);
        label.setMaxHeight(10000);

        Label sizer = new Label(text);
        sizer.setVisible(false);
        sizer.setPadding(new Insets(100));

        sizer.setMinWidth(0);
        sizer.setMinHeight(0);
        sizer.setMaxWidth(10000);
        sizer.setMaxHeight(10000);

        StackPane pane = new StackPane(label, sizer);

        return pane;
    }
}