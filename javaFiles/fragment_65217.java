import java.util.List;
import java.util.ArrayList;

import javafx.beans.Observable;
import javafx.geometry.Bounds;
import javafx.geometry.NodeOrientation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TabDragTest2 extends Application {

    private static Tab createTab(String title) {
        Tab tab = new Tab();
        tab.setGraphic(new Label(title));
        return tab;
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        tabPane.setTabDragPolicy(TabPane.TabDragPolicy.REORDER);

        tabPane.getTabs().add(createTab("First"));
        tabPane.getTabs().add(createTab("Second"));
        tabPane.getTabs().add(createTab("Third"));
        tabPane.getTabs().add(createTab("Fourth"));
        tabPane.getTabs().add(createTab("Fifth"));

        tabPane.getTabs().addListener((Observable o) -> {
            List<Tab> tabs = new ArrayList<>(tabPane.getTabs());

            NodeOrientation orientation = tabPane.getEffectiveNodeOrientation();
            boolean ltr = orientation == NodeOrientation.LEFT_TO_RIGHT;

            tabs.sort((t1, t2) -> {
                Node title1 = t1.getGraphic();
                Node title2 = t2.getGraphic();
                Bounds title1Bounds =
                    title1.localToScene(title1.getLayoutBounds());
                Bounds title2Bounds =
                    title2.localToScene(title2.getLayoutBounds());

                if (tabPane.getSide().isHorizontal()) {
                    if (ltr) {
                        return Double.compare(
                            title1Bounds.getMinX(), title2Bounds.getMinX());
                    } else {
                        return Double.compare(
                            title2Bounds.getMaxX(), title1Bounds.getMaxX());
                    }
                } else {
                    return Double.compare(
                        title1Bounds.getMinY(), title2Bounds.getMinY());
                }
            });

            if (!tabPane.getTabs().equals(tabs)) {
                Platform.runLater(() -> tabPane.getTabs().setAll(tabs));
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("TabPane bug");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}