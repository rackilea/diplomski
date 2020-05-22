import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ListViewWithCheckBox extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        ListView<Item> listView = new ListView<>();
        for (int i = 1; i <= 20; i++) {
            Item item = new Item("Item " + i, false);

            // observe item's on property and display message if it changes:
            item.onProperty().addListener((obs, wasOn, isNowOn) -> {
                System.out.println(item.getName() + " changed on state from " + wasOn + " to " + isNowOn);
                if (isNowOn) {
                    listView.getItems().remove(item);
                }
            });

            listView.getItems().add(item);
        }

        listView.setCellFactory(CheckBoxListCell.forListView((Item item) -> item.onProperty()));

        removeItem(listView);

        BorderPane root = new BorderPane(listView);
        Scene scene = new Scene(root, 250, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static class Item
    {

        private final StringProperty name = new SimpleStringProperty();
        private final BooleanProperty on = new SimpleBooleanProperty();

        public Item(String name, boolean on)
        {
            setName(name);
            setOn(on);
        }

        public final StringProperty nameProperty()
        {
            return this.name;
        }

        public final String getName()
        {
            return this.nameProperty().get();
        }

        public final void setName(final String name)
        {
            this.nameProperty().set(name);
        }

        public final BooleanProperty onProperty()
        {
            return this.on;
        }

        public final boolean isOn()
        {
            return this.onProperty().get();
        }

        public final void setOn(final boolean on)
        {
            this.onProperty().set(on);
        }

        @Override
        public String toString()
        {
            return getName();
        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public void removeItem(ListView listView)
    {
        listView.getItems().removeIf((t) -> {
            return ((Item) t).getName().equals("Item 9");
        });
    }
}