import java.util.Random;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TableViewHighlightItem extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create table and columns:
        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> nameCol = column("Name", Item::nameProperty);
        TableColumn<Item, Number> valueCol = column("Value", Item::valueProperty);
        table.getColumns().add(nameCol);
        table.getColumns().add(valueCol);

        // basic default cell, but with "value-cell" always added as a CSS class:
        valueCol.setCellFactory(col -> {
            TableCell<Item, Number> cell = new TableCell<Item, Number>(){
                @Override
                public void updateItem(Number value, boolean empty) {
                    super.updateItem(value, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(value.toString());
                    }
                }
            };
            cell.getStyleClass().add("value-cell");
            return cell ;
        });

        PseudoClass high = PseudoClass.getPseudoClass("high");

        // Table row toggles "high" pseudoclass according to state of current item in row:
        table.setRowFactory(tv -> {
            TableRow<Item> row = new TableRow<>();

            ChangeListener<Boolean> highListener = (obs, wasHigh, isNowHigh) -> 
                row.pseudoClassStateChanged(high, isNowHigh);

            row.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (oldItem != null) {
                    oldItem.highProperty().removeListener(highListener);
                }
                if (newItem == null) {
                    row.pseudoClassStateChanged(high, false);
                } else {
                    row.pseudoClassStateChanged(high, newItem.isHigh());
                    newItem.highProperty().addListener(highListener);
                }
            });

            return row ;
        });

        Random rng = new Random();

        // Button to test changing data to random values:
        Button changeButton = new Button("Change Data");
        changeButton.setOnAction(e -> 
                table.getItems().forEach(item -> item.setValue(rng.nextInt(20))));

        // add data to table:
        for (int i = 1 ; i <= 40 ; i++) {
            table.getItems().add(new Item("Item "+i, rng.nextInt(20)));
        }

        // layout:
        BorderPane root = new BorderPane(table, null, null, changeButton, null);
        BorderPane.setAlignment(changeButton, Pos.CENTER);
        BorderPane.setMargin(changeButton, new Insets(10));
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("highlight-cell-in-row.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // utility method for creating columns:
    private static <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> column = new TableColumn<>(title);
        column.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return column ;
    }

    // model class:
    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final IntegerProperty value = new SimpleIntegerProperty();
        private final ReadOnlyBooleanWrapper high = new ReadOnlyBooleanWrapper();

        public Item(String name, int value) {
            setName(name);
            setValue(value);
            high.bind(this.value.greaterThanOrEqualTo(10));
        }

        public final StringProperty nameProperty() {
            return this.name;
        }

        public final String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final String name) {
            this.nameProperty().set(name);
        }

        public final IntegerProperty valueProperty() {
            return this.value;
        }

        public final int getValue() {
            return this.valueProperty().get();
        }

        public final void setValue(final int value) {
            this.valueProperty().set(value);
        }

        public final ReadOnlyBooleanProperty highProperty() {
            return this.high.getReadOnlyProperty();
        }

        public final boolean isHigh() {
            return this.highProperty().get();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}