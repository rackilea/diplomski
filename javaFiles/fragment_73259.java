import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ListView<CheckBoxListItem> listView = new ListView<>();
        ScrollPane scrollPane = new ScrollPane(listView);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        for (int i = 1; i < 15; i++) {
            listView.getItems().add(new CheckBoxListItem("Value" + i));
        }

//        listView.setCellFactory(CheckBoxListCell.forListView(CheckBoxListItem::selectedProperty, new StringConverter<    CheckBoxListItem>() {
//            @Override
//            public String toString(CheckBoxListItem object) {
//                return object.getName();
//            }
//
//            @Override
//            public CheckBoxListItem fromString(String string) {
//                return null;
//            }
//        }));


        ObjectProperty<CheckBoxListCell<CheckBoxListItem>> dragSource = new SimpleObjectProperty<>();
        listView.setCellFactory(lv -> {
            CheckBoxListCell<CheckBoxListItem> cell = new CheckBoxListCell<>(CheckBoxListItem::selectedProperty, new StringConverter<CheckBoxListItem>() {
                @Override
                public String toString(CheckBoxListItem object) {
                    return object.getName();
                }

                @Override
                public CheckBoxListItem fromString(String string) {
                    return null;
                }
            });

            cell.setOnDragDetected(event -> {
                System.out.println("Detected fired...");
            });
            cell.setOnDragOver(event -> {
                System.out.println("DragOver fired...");
            });
            cell.setOnDragDropped(event -> {
                System.out.println("DragDropped fired...");
            });
            return cell;
        });


        Scene scene = new Scene(scrollPane, 350, 450);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.exit(0);
    }

}