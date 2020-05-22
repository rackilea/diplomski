import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IndependentPaginationTest extends Application {

    private static final int NUM_PAGES = 20 ;
    private static final int ITEMS_PER_PAGE = 20 ;

    @Override
    public void start(Stage primaryStage) {
        TableView<String> table = new TableView<>();
        TableColumn<String, String> col = new TableColumn<>("Item");
        table.getColumns().add(col);

        col.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue()));
        updateTable(table, 0);

        Pagination pagination = new Pagination();
        pagination.setPageCount(NUM_PAGES);

        pagination.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> 
                updateTable(table, newIndex.intValue()));

        BorderPane root = new BorderPane(table, null, null, pagination, null);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void updateTable(TableView<String> table, Integer index) {
        int start = index * ITEMS_PER_PAGE + 1;
        int end = start + ITEMS_PER_PAGE ;
        table.getItems().setAll(
                IntStream.range(start, end)
                .mapToObj(Integer::toString)
                .map("Item "::concat)
                .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}