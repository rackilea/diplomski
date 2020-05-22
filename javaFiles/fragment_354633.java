import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixTable extends Application {
    private Random random = new Random(42);
    private static final int N_COLS = 4;
    private static final int N_ROWS = 100;
    private static final int MAX_DATA_VALUE = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ObservableList<double[]> data = generateData();

        TableView<double[]> table = new TableView<>(data);
        table.getColumns().setAll(createColumns());
        table.setPrefSize(200, 250);

        stage.setScene(new Scene(table));
        stage.show();
    }

    private ObservableList<double[]> generateData() {
        return FXCollections.observableArrayList(
                IntStream.range(0, N_ROWS)
                        .mapToObj(r ->
                                IntStream.range(0, N_COLS)
                                        .mapToDouble(c -> randomValue())
                                        .toArray()
                        ).collect(Collectors.toList())
        );
    }

    private List<TableColumn<double[], Double>> createColumns() {
        return IntStream.range(0, N_COLS)
                .mapToObj(this::createColumn)
                .collect(Collectors.toList());
    }

    private TableColumn<double[], Double> createColumn(int c) {
        TableColumn<double[], Double> col = new TableColumn<>("C" + (c + 1));
        col.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()[c]));

        return col;
    }

    private long randomValue() {
        return Math.round(random.nextDouble() * MAX_DATA_VALUE  * 100) / 100.0;
    }
}