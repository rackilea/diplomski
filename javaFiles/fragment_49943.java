import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Remover extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<NamedColor> colors = FXCollections.observableArrayList(
                new NamedColor("red", Color.RED),
                new NamedColor("green", Color.GREEN),
                new NamedColor("blue", Color.BLUE),
                new NamedColor("indigo", Color.INDIGO)
        );

        TableView<NamedColor> table = new TableView<>(colors);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<NamedColor, String> colorNames = new TableColumn<>("Colors");
        colorNames.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(colorNames);

        Button remove = new Button("Remove");
        remove.disableProperty().bind(
                Bindings.isEmpty(
                        table.getSelectionModel().getSelectedItems()
                )
        );
        remove.setMaxWidth(Double.MAX_VALUE);
        remove.setOnAction(event ->
                table.getItems()
                        .removeAll(
                                table.getSelectionModel().getSelectedItems()
                        )
        );

        VBox layout = new VBox(table, remove);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(Remover.class);
    }

    public static class NamedColor {
        private String name;
        private Color color;

        public NamedColor(String name, Color color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public Color getColor() {
            return color;
        }
    }
}