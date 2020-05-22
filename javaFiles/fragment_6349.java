import java.util.Random;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TableWithValidationColumn extends Application {

    private final Image validImage = createImage(20, 20, Color.GREEN);
    private final Image invalidImage = createImage(20, 20, Color.RED);

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();
        table.getColumns().add(column("Item", Item::nameProperty));
        table.getColumns().add(column("Value", Item::valueProperty));

        TableColumn<Item, Boolean> validColumn = new TableColumn<>("Validated");

        ObservableSet<Item> validItems = FXCollections.observableSet();

        validColumn.setCellValueFactory(cellData -> {
            Item item = cellData.getValue() ;
            return Bindings.createBooleanBinding(() -> validItems.contains(item), validItems);
        });

        validColumn.setCellFactory(col -> new TableCell<Item, Boolean>() {
            private final ImageView imageView = new ImageView();
            @Override
            protected void updateItem(Boolean valid, boolean empty) {
                super.updateItem(valid, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    if (valid) {
                        imageView.setImage(validImage);
                    } else {
                        imageView.setImage(invalidImage);
                    }
                    setGraphic(imageView);
                }
            }
        });

        table.getColumns().add(validColumn);

        // validate on double-click:

        table.setRowFactory(tv -> {
            TableRow<Item> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if ((! row.isEmpty())  && e.getClickCount() == 2) {
                    Item item = row.getItem() ;
                    if (validItems.contains(item)) {
                        validItems.remove(item);
                    } else {
                        if (validate(item)) {
                            validItems.add(item);
                        }
                    }
                }
            });
            return row ;
        });

        Random rng = new Random();
        for (int i = 1 ; i <= 100 ; i++) {
            table.getItems().add(new Item("Item "+i, rng.nextInt(100)));
        }

        BorderPane root = new BorderPane(table);
        Scene scene = new Scene(root, 600 ,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean validate(Item item) {
        // items with even values validate:
        return item.getValue() % 2 == 0;
    }

    private static <S,T> TableColumn<S,T> column(String text, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(text);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }

    private final Image createImage(int w, int h, Color color) {
        Rectangle rect = new Rectangle(w, h, color);
        return rect.snapshot(null, null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final IntegerProperty value = new SimpleIntegerProperty();

        public Item(String name, int value) {
            setName(name);
            setValue(value);
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



    }
}