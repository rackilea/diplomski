import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewTest extends Application {

    private TableView<Arbeitgeber> arbeitgeberTable;
    private TableView<Person> personTable;

    ObservableList<String> gruppeOptions =
        FXCollections.observableArrayList(
                "Arbeiter",
                "Angestellter",
                "Leiter"
        );

    private ObservableList<Arbeitgeber> arbeitgeberListe = FXCollections.observableArrayList(new Arbeitgeber(1, "Goldgräber Inc."), new Arbeitgeber(2, "Hamster GmbH"), new Arbeitgeber(3, "Wissen"));
    private ObservableList<Person> personen = FXCollections.observableArrayList(
            new Person(1, "Max Musterman", gruppeOptions.get(1), arbeitgeberListe.get(0)),
            new Person(2, "Bernd Brot", gruppeOptions.get(0), arbeitgeberListe.get(0)),
            new Person(3, "Fred Feuer", gruppeOptions.get(2), arbeitgeberListe.get(1)),
            new Person(4, "Uli Stein", gruppeOptions.get(1), arbeitgeberListe.get(2)));

    @Override
    public void start(Stage primaryStage) throws Exception {
        createArbeitgeberTableview();
        createPersonTableview();

        VBox vbox = new VBox(15);

        Label aLabel = new Label("Arbeitgeber");
        Label pLabel = new Label("Personen");
        vbox.getChildren().addAll(aLabel, arbeitgeberTable, pLabel, personTable);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private TableView<Arbeitgeber> createArbeitgeberTableview() {
        arbeitgeberTable = new TableView<>(arbeitgeberListe);

        arbeitgeberTable.setEditable(true);

        TableColumn<Arbeitgeber, Integer> idCol = new TableColumn<>("ID");
        TableColumn nameCol = new TableColumn<>("Name");

        idCol.setCellValueFactory(new PropertyValueFactory<Arbeitgeber, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Arbeitgeber, String>("name"));


        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Arbeitgeber,String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<Arbeitgeber, String> event) {
                ((Arbeitgeber) event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(event.getNewValue());

                for(Person p : personTable.getItems()) {
                    System.out.println(p.getArbeitgeber()); //shows the new value
                }
            }
        });

        arbeitgeberTable.getColumns().addAll(idCol, nameCol);
        arbeitgeberTable.setTableMenuButtonVisible(true);
        return arbeitgeberTable;
    }

    @SuppressWarnings("unchecked")
    private TableView<Person> createPersonTableview(){
        personTable = new TableView<>(personen);

        TableColumn<Person, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        TableColumn<Person, String> gruppeCol = new TableColumn<>("Gruppe");
        TableColumn<Person, String> arbCol = new TableColumn<>("Arbeitgeber");

        idCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        gruppeCol.setCellValueFactory(new PropertyValueFactory<Person, String>("gruppe"));

          arbCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>>() {
              public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> p) {
                  return Bindings.selectString(
                      new ReadOnlyObjectWrapper<Object>(
                          p.getValue()
                      ), 
                     "arbeitgeber", "name"
                  );
              }
          });

        personTable.getColumns().addAll(idCol, nameCol, gruppeCol, arbCol);
        personTable.setTableMenuButtonVisible(true);
        return personTable;
    }
}