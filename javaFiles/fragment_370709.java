import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighlightingLabelLayoutTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextField searchField = new TextField();

        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> itemCol = new TableColumn<>("Item");
        itemCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        table.getColumns().add(itemCol);

        TableColumn<Item, String> dataCol = new TableColumn<>("Data");
        dataCol.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
        dataCol.setPrefWidth(200);
        table.getColumns().add(dataCol);

        dataCol.setCellFactory(col -> new TableCell<Item, String>() {
            private final HighlightingLabelLayout layout = new HighlightingLabelLayout();

            {
                layout.highlightTextProperty().bind(searchField.textProperty());
            }

            @Override
            protected void updateItem(String data, boolean empty) {
                super.updateItem(data, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    layout.setText(data);
                    setGraphic(layout);
                }
            }
        });

        table.getItems().setAll(generateData(200, 10));



        VBox root = new VBox(5, searchField, table);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private List<Item> generateData(int numItems, int wordsPerItem) {
        List<Item> items = new ArrayList<>();
        Random rng = new Random();
        for (int i = 1 ; i <= numItems ; i++) {
            String name = "Item "+i;
            List<String> words = new ArrayList<>();
            for (int j = 0 ; j < wordsPerItem ; j++) {
                words.add(WORDS[rng.nextInt(WORDS.length)].toLowerCase());
            }
            String data = String.join(" ", words);
            items.add(new Item(name, data));
        }
        return items ;
    }

    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final StringProperty data = new SimpleStringProperty();

        public Item(String name, String data) {
            setName(name);
            setData(data);
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


        public final StringProperty dataProperty() {
            return this.data;
        }


        public final String getData() {
            return this.dataProperty().get();
        }


        public final void setData(final String data) {
            this.dataProperty().set(data);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final String[] WORDS = ("Lorem ipsum dolor sit amet, "
            + "consectetur adipiscing elit. Sed pulvinar massa at arcu ultrices, "
            + "nec elementum velit vestibulum. Integer eget elit justo. "
            + "Orci varius natoque penatibus et magnis dis parturient montes, "
            + "nascetur ridiculus mus. Duis ultricies diam turpis, eget accumsan risus convallis a. "
            + "Pellentesque rhoncus viverra sem, sed consequat lorem.").split("\\W") ;
}