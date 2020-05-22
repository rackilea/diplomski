import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.stream.*;

public class TreeViewSample extends Application {
    @Override public void start(Stage stage) {
        TreeItem<String> rootItem = new TreeItem<>("Inbox");
        rootItem.setExpanded(true);
        IntStream.range(0, 6)
                .mapToObj(i -> new TreeItem<>("Message" + i))
                .collect(Collectors.toCollection(rootItem::getChildren));

        rootItem.expandedProperty().addListener(observable -> {
            if (!rootItem.isExpanded()) {
                rootItem.setExpanded(true);
            }
        });

        TreeView<String> tree = new TreeView<>(rootItem);
        stage.setScene(new Scene(new StackPane(tree), 300, 250));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}