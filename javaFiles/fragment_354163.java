import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class TradeTableExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Trade> table = new TableView<>();
        table.setEditable(true);
        TableColumn<Trade, String> nameCol = column("Name", trade -> new ReadOnlyStringWrapper(trade.getName()));
        TableColumn<Trade, Integer> volumeCol = column("Volume", t -> t.volumeProperty().asObject());
        TableColumn<Trade, Double> priceCol = column("Price", t -> t.priceProperty().asObject());
        TableColumn<Trade, Number> totalCol = column("Total", Trade::totalProperty);

        volumeCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        table.getColumns().addAll(Arrays.asList(nameCol, volumeCol, priceCol, totalCol));

        ObservableList<Trade> data = FXCollections.observableArrayList(trade -> new Observable[] {trade.totalProperty()});

        DoubleBinding grandTotal = Bindings.createDoubleBinding(() -> 
            data.stream().collect(Collectors.summingDouble(Trade::getTotal)),
            data);

        data.addAll(createData());
        table.setItems(data);

        Label totalLabel = new Label();
        totalLabel.textProperty().bind(grandTotal.asString("Total: %,.2f"));

        TextField nameField = new TextField();
        TextField volumeField = new TextField("0");
        TextField priceField = new TextField("0.00");

        Button add = new Button("Add");
        add.setOnAction(e -> {
            data.add(
                new Trade(nameField.getText(), 
                        Integer.parseInt(volumeField.getText()), 
                        Double.parseDouble(priceField.getText())));
            nameField.setText("");
            volumeField.setText("0");
            priceField.setText("0.00");
        });

        Button delete = new Button("Delete");
        delete.setOnAction(e -> data.remove(table.getSelectionModel().getSelectedIndex()));
        delete.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());

        HBox buttons = new HBox(5, add, delete);

        GridPane controls = new GridPane();
        controls.addRow(0, new Label("Name:"), nameField);
        controls.addRow(1, new Label("Volume:"), volumeField);
        controls.addRow(2, new Label("Price:"), priceField);
        controls.add(buttons, 0, 3, 2, 1);
        controls.add(totalLabel, 0, 4, 2, 1);

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHgrow(Priority.ALWAYS);

        controls.getColumnConstraints().addAll(leftCol, rightCol);

        GridPane.setHalignment(controls, HPos.LEFT);
        GridPane.setHalignment(totalLabel, HPos.LEFT);

        controls.setHgap(5);
        controls.setVgap(5);

        BorderPane root = new BorderPane(table, null, null, controls, null);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Trade> createData() {
        Random rng = new Random();
        List<Trade> trades = new ArrayList<>();
        for (int i=0; i<10; i++) {
            StringBuilder name = new StringBuilder();
            for (int c = 0; c < 3; c++) {
                name.append(Character.toString((char)(rng.nextInt(26)+'A')));
            }
            double price = rng.nextInt(100000)/100.0 ;
            int volume = rng.nextInt(10000);
            trades.add(new Trade(name.toString(), volume, price));
        }
        return trades ;
    }

    private <S,T> TableColumn<S,T> column(String text, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(text);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }

    public static class Trade {
        private final String name ;
        private final IntegerProperty volume = new SimpleIntegerProperty();
        private final DoubleProperty price = new SimpleDoubleProperty();
        private final ReadOnlyDoubleWrapper total = new ReadOnlyDoubleWrapper();

        public Trade(String name, int volume, double price) {
            this.name = name ;
            setPrice(price);
            setVolume(volume);
            total.bind(priceProperty().multiply(volumeProperty()));
        }

        public final String getName() {
            return name ;
        }

        public final IntegerProperty volumeProperty() {
            return this.volume;
        }

        public final int getVolume() {
            return this.volumeProperty().get();
        }

        public final void setVolume(final int volume) {
            this.volumeProperty().set(volume);
        }

        public final DoubleProperty priceProperty() {
            return this.price;
        }

        public final double getPrice() {
            return this.priceProperty().get();
        }

        public final void setPrice(final double price) {
            this.priceProperty().set(price);
        }

        public final ReadOnlyDoubleProperty totalProperty() {
            return this.total.getReadOnlyProperty();
        }

        public final double getTotal() {
            return this.totalProperty().get();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}