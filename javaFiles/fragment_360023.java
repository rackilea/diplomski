import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.stream.IntStream;

public class ScrollThroughTransparentStage_Demo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Main Window");
        VBox root = new VBox(buildScrollPane());
        root.setStyle("-fx-background-color:#888888;");
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Button normalStageBtn = new Button("Normal Stage");
        normalStageBtn.setOnAction(e -> {
            Stage normalStage = new Stage();
            normalStage.initOwner(stage);
            Scene normalScene = new Scene(buildScrollPane(), 300, 300);
            addHandlers(normalScene);
            normalStage.setScene(normalScene);
            normalStage.show();
        });

        CheckBox allowScrollThrough = new CheckBox("Allow scroll through transparency");
        allowScrollThrough.setSelected(true);

        HBox buttons = new HBox(normalStageBtn);
        buttons.setSpacing(20);
        root.getChildren().addAll(allowScrollThrough,buttons);
        Scene scene = new Scene(root, 600, 600);
        addHandlers(scene);
        stage.setScene(scene);
        stage.show();

        /* Transparent Stage */
        Stage transparentStage = new Stage();
        transparentStage.initOwner(stage);
        transparentStage.initStyle(StageStyle.TRANSPARENT);
        Pane mainRoot = new Pane();
        Pane transparentRoot = new Pane(mainRoot);
        transparentRoot.setStyle("-fx-background-color:transparent;");
        Scene transparentScene = new Scene(transparentRoot, Color.TRANSPARENT);
        transparentStage.setScene(transparentScene);
        transparentScene.addEventFilter(ScrollEvent.SCROLL, e -> {
            if (allowScrollThrough.isSelected() && HoverNodeSingleton.getInstance().getHoverNode() != null) {
                Event.fireEvent(HoverNodeSingleton.getInstance().getHoverNode(), e);
            }
        });
        transparentScene.addEventHandler(ScrollEvent.SCROLL, e -> {
            if (allowScrollThrough.isSelected() && HoverNodeSingleton.getInstance().getHoverNode() != null) {
                Event.fireEvent(HoverNodeSingleton.getInstance().getHoverNode(), e);
            }
        });
        determineStageSize(transparentStage, mainRoot);
        transparentStage.show();

        Button transparentStageBtn = new Button("Transparent Stage");
        transparentStageBtn.setOnAction(e -> {
            MiniStage miniStage = new MiniStage(mainRoot);
            ScrollPane scrollPane = buildScrollPane();
            scrollPane.setPrefSize(300, 300);
            miniStage.setContent(scrollPane);
            miniStage.show();
        });
        buttons.getChildren().add(transparentStageBtn);
    }

    private static void determineStageSize(Stage stage, Node root) {
        DoubleProperty width = new SimpleDoubleProperty();
        DoubleProperty height = new SimpleDoubleProperty();
        DoubleProperty shift = new SimpleDoubleProperty();
        Screen.getScreens().forEach(screen -> {
            Rectangle2D bounds = screen.getVisualBounds();
            width.set(width.get() + bounds.getWidth());

            if (bounds.getHeight() > height.get()) {
                height.set(bounds.getHeight());
            }
            if (bounds.getMinX() < shift.get()) {
                shift.set(bounds.getMinX());
            }
        });
        stage.setX(shift.get());
        stage.setY(0);
        stage.setWidth(width.get());
        stage.setHeight(height.get());
        root.setTranslateX(-1 * shift.get());
    }

    private void addHandlers(Scene scene) {
        scene.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, e -> {
            HoverNodeSingleton.getInstance().setHoverNode(null);
        });
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
            HoverNodeSingleton.getInstance().setHoverNode(e.getTarget());
        });
    }

    private ScrollPane buildScrollPane() {
        VBox vb = new VBox();
        vb.setSpacing(10);
        vb.setPadding(new Insets(15));
        IntStream.rangeClosed(1, 100).forEach(i -> vb.getChildren().add(new Label(i + "")));
        ScrollPane scrollPane = new ScrollPane(vb);
        return scrollPane;
    }

    class MiniStage extends Group {
        private Pane parent;
        double sceneX, sceneY, layoutX, layoutY;
        protected BorderPane windowPane;
        private BorderPane windowTitleBar;
        private Label labelTitle;
        private Button buttonClose;

        public MiniStage(Pane parent) {
            this.parent = parent;
            buildRootNode();
            getChildren().add(windowPane);
            addEventHandler(MouseEvent.MOUSE_PRESSED, e -> toFront());
        }

        @Override
        public void toFront() {
            parent.getChildren().remove(this);
            parent.getChildren().add(this);
        }

        public void setContent(Node content) {
            // Computing the bounds of the content before rendering
            Group grp = new Group(content);
            new Scene(grp);
            grp.applyCss();
            grp.requestLayout();
            double width = grp.getLayoutBounds().getWidth();
            double height = grp.getLayoutBounds().getHeight() + 30; // 30 title bar height
            grp.getChildren().clear();

            windowPane.setCenter(content);
            // Centering the stage
            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            setX(screenBounds.getWidth() / 2 - width / 2);
            setY(screenBounds.getHeight() / 2 - height / 2);
        }

        public Node getContent() {
            return windowPane.getCenter();
        }

        public void setX(double x) {
            setLayoutX(x);
        }

        public void setY(double y) {
            setLayoutY(y);
        }

        public void show() {
            if (!parent.getChildren().contains(this)) {
                parent.getChildren().add(this);
            }
        }

        public void hide() {
            parent.getChildren().remove(this);
        }

        private void buildRootNode() {
            windowPane = new BorderPane();
            windowPane.setStyle("-fx-border-width:2px;-fx-border-color:#444444;");
            labelTitle = new Label("Mini Stage");
            labelTitle.setStyle("-fx-font-weight:bold;");
            labelTitle.setMaxHeight(Double.MAX_VALUE);
            buttonClose = new Button("X");
            buttonClose.setFocusTraversable(false);
            buttonClose.setStyle("-fx-background-color:red;-fx-background-radius:0;-fx-background-insets:0;");
            buttonClose.setOnMouseClicked(evt -> hide());

            windowTitleBar = new BorderPane();
            windowTitleBar.setStyle("-fx-border-width: 0 0 2px 0;-fx-border-color:#444444;-fx-background-color:#BBBBBB");
            windowTitleBar.setLeft(labelTitle);
            windowTitleBar.setRight(buttonClose);
            windowTitleBar.setPadding(new Insets(0, 0, 0, 10));
            windowTitleBar.getStyleClass().add("nonfocus-title-bar");
            windowPane.setTop(windowTitleBar);
            assignTitleBarEvents();
        }

        private void assignTitleBarEvents() {
            windowTitleBar.setOnMousePressed(this::recordWindowLocation);
            windowTitleBar.setOnMouseDragged(this::moveWindow);
            windowTitleBar.setOnMouseReleased(this::resetMousePointer);
        }

        private final void recordWindowLocation(final MouseEvent event) {
            sceneX = event.getSceneX();
            sceneY = event.getSceneY();
            layoutX = getLayoutX();
            layoutY = getLayoutY();
            getScene().setCursor(Cursor.MOVE);
        }

        private final void resetMousePointer(final MouseEvent event) {
            // Updating the new layout positions
            setLayoutX(layoutX + getTranslateX());
            setLayoutY(layoutY + getTranslateY());

            // Resetting the translate positions
            setTranslateX(0);
            setTranslateY(0);
            getScene().setCursor(Cursor.DEFAULT);
        }

        private final void moveWindow(final MouseEvent event) {
            double offsetX = event.getSceneX() - sceneX;
            double offsetY = event.getSceneY() - sceneY;
            setTranslateX(offsetX);
            setTranslateY(offsetY);
            event.consume();
        }
    }
}

/**
 * Singleton class.
 */
class HoverNodeSingleton {
    private static HoverNodeSingleton INSTANCE = new HoverNodeSingleton();
    private EventTarget hoverNode;

    private HoverNodeSingleton() {
    }

    public static HoverNodeSingleton getInstance() {
        return INSTANCE;
    }

    public EventTarget getHoverNode() {
        return hoverNode;
    }

    public void setHoverNode(EventTarget hoverNode) {
        this.hoverNode = hoverNode;
    }
}