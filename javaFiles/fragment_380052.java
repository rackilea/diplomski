import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class HighlightDuplicateTableCells extends Application {

    // create an observable list that fires events if the dataProperty of any elements change:

    private final ObservableList<Item> items = 
            FXCollections.observableArrayList(item -> new Observable[]{item.dataProperty()});

    // collection of strings that are duplicated in the data properties of all the items:

    private final ObservableSet<String> duplicateData = FXCollections.observableSet();

    private static final PseudoClass DUPLICATE_PC = PseudoClass.getPseudoClass("duplicate");

    private final StringConverter<String> identityStringConverter = new StringConverter<String>() {

        @Override
        public String toString(String object) {
            return object;
        }

        @Override
        public String fromString(String string) {
            return string;
        }

    };

    @Override
    public void start(Stage primaryStage) {

        // listener to maintain collection of duplicates:
        items.addListener((Change<? extends Item> change) -> updateDuplicateData());

        TableView<Item> table = new TableView<>();
        table.setEditable(true);
        table.setItems(items);

        TableColumn<Item, Number> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));

        TableColumn<Item, String> dataColumn = new TableColumn<>("Data");
        dataColumn.setCellValueFactory(cellData -> cellData.getValue().dataProperty());

        dataColumn.setCellFactory(tc -> {

            TextFieldTableCell<Item, String> cell = new TextFieldTableCell<Item, String>(identityStringConverter) {

                // boolean binding that indicates if the current item is contained in the duplicateData set:
                private BooleanBinding duplicate = Bindings.createBooleanBinding(
                        () -> duplicateData.contains(getItem()),
                        duplicateData, itemProperty());

                // anonymous constructor just updates CSS pseudoclass if above binding changes:
                {
                    duplicate.addListener((obs, wasDuplicate, isNowDuplicate) -> 
                        pseudoClassStateChanged(DUPLICATE_PC, isNowDuplicate));
                }
            };

            return cell ;
        });

        table.getColumns().add(idColumn);
        table.getColumns().add(dataColumn);

        // note best to minimize changes to items.
        // creating a temp list and using items.setAll(...) achieves this:

        List<Item> tmp = new ArrayList<>();
        for (int i = 1 ; i <= 70; i++) {
            char c = (char)('@' + (i % 60));
            String data = Character.toString(c) ;
            tmp.add(new Item(i, data));
        }

        items.setAll(tmp);

        Scene scene = new Scene(table, 600, 600);
        scene.getStylesheets().add("duplicate-cell-example.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateDuplicateData() {

        // TODO: may not be most efficient implementation

        // all data:
        List<String> data = items.stream().map(Item::getData).collect(Collectors.toList());
        // unique data:
        Set<String> uniqueData = new HashSet<>(data);
        // remove unique values from data:
        uniqueData.forEach(data::remove);
        // remaining values are duplicates: replace contents of duplicateData with these:
        duplicateData.clear();
        duplicateData.addAll(data);
    }

    public static class Item {
        private final int id ;
        private final StringProperty data = new SimpleStringProperty();

        public Item(int id, String data) {
            this.id = id ;
            setData(data);
        }

        public final StringProperty dataProperty() {
            return this.data;
        }


        public final String getData() {
            return this.dataProperty().get();
        }


        public final void setData(final String data) {
            this.dataProperty().set(data);
        }

        public int getId() {
            return id ;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}