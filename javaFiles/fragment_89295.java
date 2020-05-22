package finder;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TableScrollerController {
    private static final String[] fruitNames = {
            "apples", "oranges", "pears", "peaches", 
            "guavas", "bananas", "jackfruit", "durians"
    };

    @FXML
    private TableView<Fruit> fruitsTable;

    @FXML
    private TableColumn<Fruit, String> fruitsColumn;

    @FXML
    protected void initialize() {
        fruitsColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        fruitsTable.addEventFilter(ScrollEvent.ANY, event ->
                System.out.println("Coded scroll filter: " + event)
        );

        fruitsTable.getItems().setAll(
                Arrays.stream(fruitNames)
                        .map(Fruit::new)
                        .collect(Collectors.toList())
        );

        fruitsTable.scrollTo(5);
    }

    @FXML
    protected void onScrollHandler(ScrollEvent scrollEvent) {
        System.out.println("FXML referenced scroll handler: " + scrollEvent);
    }

    @FXML
    protected void onScrollToHandler(ScrollToEvent<Integer> scrollToEvent) {
        System.out.println("FXML referenced onScroll handler: " + scrollToEvent);
    }

    public static class Fruit {
        private ReadOnlyStringWrapper name;

        public Fruit(String name) {
            this.name = new ReadOnlyStringWrapper(name);
        }

        public String getName() {
            return name.get();
        }

        public ReadOnlyStringProperty nameProperty() {
            return name;
        }
    }
}