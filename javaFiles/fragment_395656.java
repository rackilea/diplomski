import java.util.Random;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class CellHighlightingTable extends Application {

    public static class VerifiableValue<T> {

        public enum VerificationState { UNVERIFIED, VERIFIED, ERROR }

        private final T value ;
        private final ObjectProperty<VerificationState> verificationState = new SimpleObjectProperty<>(VerificationState.UNVERIFIED) ;

        public VerifiableValue(T value) {
            this.value = value ;
        }

        public VerifiableValue(T value, VerificationState verificationState) {
            this(value);
            setVerificationState(verificationState);
        }



        public T getValue() {
            return value ;
        }

        public final ObjectProperty<VerificationState> verificationStateProperty() {
            return this.verificationState;
        }


        public final CellHighlightingTable.VerifiableValue.VerificationState getVerificationState() {
            return this.verificationStateProperty().get();
        }


        public final void setVerificationState(
                final CellHighlightingTable.VerifiableValue.VerificationState verificationState) {
            this.verificationStateProperty().set(verificationState);
        }


    }

    private <T> TableCell<Product, VerifiableValue<T>> createTableCell(String format, Function<String, T> supplier) {
        TextFieldTableCell<Product, VerifiableValue<T>> cell = new TextFieldTableCell<>();

        cell.setConverter(new StringConverter<VerifiableValue<T>>() {

            @Override
            public String toString(VerifiableValue<T> item) {
                return item == null ? "" : String.format(format, item.getValue());
            }

            @Override
            public VerifiableValue<T> fromString(String string) {
                T value = supplier.apply(string);
                VerifiableValue.VerificationState verificationState = cell.getItem() == null ? VerifiableValue.VerificationState.UNVERIFIED : cell.getItem().getVerificationState() ;
                return new VerifiableValue<>(value, verificationState);
            }

        });

        ChangeListener<VerifiableValue.VerificationState> verifiedListener = (obs, oldState, newState) -> {
            if (newState == null || newState == VerifiableValue.VerificationState.UNVERIFIED) {
                cell.setStyle("");
            } else if (newState == VerifiableValue.VerificationState.VERIFIED) {
                cell.setStyle("-fx-background-color: yellow ;");
            } else if (newState == VerifiableValue.VerificationState.ERROR) {
                cell.setStyle("-fx-background-color: red ;");
            }
        };


        cell.itemProperty().addListener((obs, oldItem, newItem) -> {
            if (oldItem != null) {
                oldItem.verificationStateProperty().removeListener(verifiedListener);
            }
            if (newItem == null) {
                cell.setStyle("");
            } else {
                if (newItem.getVerificationState() == null || newItem.getVerificationState() == VerifiableValue.VerificationState.UNVERIFIED) {
                    cell.setStyle("");
                } else if (newItem.getVerificationState() == VerifiableValue.VerificationState.VERIFIED) {
                    cell.setStyle("-fx-background-color: yellow ;");
                } else if (newItem.getVerificationState() == VerifiableValue.VerificationState.ERROR) {
                    cell.setStyle("-fx-background-color: red ;");
                }               
                newItem.verificationStateProperty().addListener(verifiedListener);
            }
        });

        return cell ;
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<Product> table = new TableView<>();
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setEditable(true);

        TableColumn<Product, String> productCol = new TableColumn<>("Product");
        productCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Product, VerifiableValue<Integer>> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());

        quantityColumn.setCellFactory(tc -> createTableCell("%,d", Integer::new));

        TableColumn<Product, VerifiableValue<Double>> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(cellData -> cellData.getValue().weightProperty());

        weightColumn.setCellFactory(tc -> createTableCell("%.3f Kg", Double::new));

        table.getColumns().add(productCol);
        table.getColumns().add(quantityColumn);
        table.getColumns().add(weightColumn);

        Button verifySelected = new Button("Verify Selected");
        verifySelected.setOnAction(e -> {
            for (TablePosition<?, ?> pos : table.getSelectionModel().getSelectedCells()) {
                if (pos.getTableColumn() == quantityColumn) {
                    Product product = table.getItems().get(pos.getRow());
                    product.getQuantity().setVerificationState(VerifiableValue.VerificationState.VERIFIED);
                } else if (pos.getTableColumn() == weightColumn) {
                    Product product = table.getItems().get(pos.getRow());
                    product.getWeight().setVerificationState(VerifiableValue.VerificationState.VERIFIED);
                }
            }
        });
        verifySelected.disableProperty().bind(Bindings.isEmpty(table.getSelectionModel().getSelectedCells()));

        Button errorSelected = new Button("Mark all selected as error");
        errorSelected.setOnAction(e -> {
            for (TablePosition<?, ?> pos : table.getSelectionModel().getSelectedCells()) {
                if (pos.getTableColumn() == quantityColumn) {
                    Product product = table.getItems().get(pos.getRow());
                    product.getQuantity().setVerificationState(VerifiableValue.VerificationState.ERROR);
                } else if (pos.getTableColumn() == weightColumn) {
                    Product product = table.getItems().get(pos.getRow());
                    product.getWeight().setVerificationState(VerifiableValue.VerificationState.ERROR);
                }
            }
        });
        errorSelected.disableProperty().bind(Bindings.isEmpty(table.getSelectionModel().getSelectedCells()));


        Button unverifyAll = new Button("Remove all verification");
        unverifyAll.setOnAction(e -> {
            for (Product product : table.getItems()) {
                product.getQuantity().setVerificationState(VerifiableValue.VerificationState.UNVERIFIED);
                product.getWeight().setVerificationState(VerifiableValue.VerificationState.UNVERIFIED);
            }
        });

        HBox buttons = new HBox(5, verifySelected, errorSelected, unverifyAll);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(5));

        // random data:
        Random rng = new Random();
        for (int i = 0 ;  i < 100; i++) {
            Product product = new Product("Item "+(i+1));
            product.setQuantity(new VerifiableValue<>(rng.nextInt(1200)));
            product.setWeight(new VerifiableValue<>(rng.nextDouble() * 1000));
            table.getItems().add(product);
        }

        BorderPane root = new BorderPane(table);
        root.setBottom(buttons);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static class Product {

        private ObjectProperty<VerifiableValue<Double>> weight = new SimpleObjectProperty<>();
        private ObjectProperty<VerifiableValue<Integer>> quantity = new SimpleObjectProperty<>();

        private final String name ;

        public Product(String name) {
            this.name = name ;
        }

        public String getName() {
            return name ;
        }

        public final ObjectProperty<VerifiableValue<Double>> weightProperty() {
            return this.weight;
        }

        public final CellHighlightingTable.VerifiableValue<java.lang.Double> getWeight() {
            return this.weightProperty().get();
        }

        public final void setWeight(final CellHighlightingTable.VerifiableValue<java.lang.Double> weight) {
            this.weightProperty().set(weight);
        }

        public final ObjectProperty<VerifiableValue<Integer>> quantityProperty() {
            return this.quantity;
        }

        public final CellHighlightingTable.VerifiableValue<java.lang.Integer> getQuantity() {
            return this.quantityProperty().get();
        }

        public final void setQuantity(final CellHighlightingTable.VerifiableValue<java.lang.Integer> quantity) {
            this.quantityProperty().set(quantity);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}