import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableOfControlsInGridPane extends Application {

    private final List<RowData> data = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(table(10), 800, 800);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane table(int rows){
        GridPane table = new GridPane();
        table.getStyleClass().add("data-grid");

        data.clear();

        for(int i=0; i<rows; i++){

            RowData rowData = new RowData();
            data.add(rowData);

            RowDataView rowDataView = new RowDataView(rowData);
            rowDataView.addToGridPane(table, i);
         }
        table.setAlignment(Pos.CENTER);
        return table;
    }

    public static void main(String[] args) {
        launch(args);
    }
}