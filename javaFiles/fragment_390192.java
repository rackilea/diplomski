import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    final TableView<String[]> tableView = new TableView<String[]>();

    @Override
    public void start(Stage stage) {

        TableColumn[] columns = {new TableColumn("c1"), new TableColumn("c2"),     new TableColumn("c3"), new TableColumn("c4")};
        tableView.getColumns().setAll(columns);

        tableView.getColumns().addListener(
                new ListChangeListener() {

                    @Override
                    public void onChanged(Change change) {

                        change.next();

                        System.out.println("old list");
                        System.out.println(change.getRemoved());

                        System.out.println("new list");
                        System.out.println(change.getList());
                    }

                });

        System.out.println("initial list");
        System.out.println(tableView.getColumns());
        stage.setScene(new Scene(tableView));
        stage.show();
    }
}