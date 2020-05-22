import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableViewBuilderExample extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) {
    final ObservableList<?> data = FXCollections.observableArrayList(
      new Person("Jacob", "Smith"),
      new Person("Isabella", "Johnson")
    );

    stage.setScene(
      new Scene(
        TableViewBuilder.create().items((ObservableList<Object>) data).columns(
          TableColumnBuilder.create().text("First Name").cellValueFactory(new PropertyValueFactory("firstName")).build(),
          TableColumnBuilder.create().text("Last Name").cellValueFactory(new PropertyValueFactory("lastName")).build()
        ).build()
      )
    );
    stage.show();
  }
}