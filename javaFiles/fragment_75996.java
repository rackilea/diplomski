import java.util.Set;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class Foo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TableView<Object> testView = new TableView<>();
        testView.getColumns().addAll(createColumn("C1"), createColumn("C2"), createColumn("C3"));

        stage.setOnShown(ev -> {
            Set<Node> headers = testView.lookupAll("TableColumnHeader");
            for (Node header : headers) {
                if (header != null) {
                    ((TableColumnHeader) header).setOnMousePressed(e -> {
                        if (e.getButton() == MouseButton.SECONDARY) {
                            e.consume();
                        }
                    });
                }
            }
        });

        stage.setScene(new Scene(testView));
        stage.show();
    }

    private TableColumn<Object, Object> createColumn(String text) {
        MenuItem item = new MenuItem("Context");
        item.setOnAction(e -> {
            System.out.println("Action");
        });

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(item);

        TableColumn<Object, Object> column = new TableColumn<>(text);
        column.setContextMenu(contextMenu);

        return column;
    }

    public static void main(String[] args) {
        launch(args);
    }
}