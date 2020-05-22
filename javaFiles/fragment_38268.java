package javafxapplication21;

import com.sun.javafx.scene.control.skin.TableViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.net.URL;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable
{
    @FXML private Button insertBtn;
    @FXML private TableView<Country> tableView;
    @FXML private TableColumn<Country, String> countryColumn;
    @FXML private TableColumn<Country, String> capitalColumn;

    private VirtualFlow flow;

    private ObservableList<Country> countries =
            FXCollections.observableArrayList();
    private List<Country> insertList = new ArrayList<>();

    public SampleController()
    {
        countries.addAll(new Country("AG", "Buenos Aires"),
                new Country("AU", "Vienna"),
                new Country("BY", "Minsk"),
                new Country("CO", "Bogota"),
                new Country("EG", "Cairo"));

        insertList.add(new Country("ZI", "Harare"));
        insertList.add(new Country("UK", "London"));
        insertList.add(new Country("TW", "Taipei"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        countryColumn.setCellValueFactory(
                new PropertyValueFactory<Country, String>("name"));
        capitalColumn.setCellValueFactory(
                new PropertyValueFactory<Country, String>("capital"));

        tableView.setItems(countries);

        tableView.skinProperty().addListener(new ChangeListener<Skin>()
        {
            @Override
            public void changed(ObservableValue<? extends Skin> ov,
                Skin t, Skin t1)
            {
                if (t1 == null) { return; }

                TableViewSkin tvs = (TableViewSkin)t1;
                ObservableList<Node> kids = tvs.getChildrenUnmodifiable();

                if (kids == null || kids.isEmpty()) { return; }

                flow = (VirtualFlow)kids.get(1);
            }
        });

        insertBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                if (!insertList.isEmpty())
                {
                    countries.add(2, insertList.get(0));
                    insertList.remove(0);
                }
            }
        });

        countries.addListener(new ListChangeListener<Country>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Country> change)
            {
                while (change.next())
                {
                    if (change.wasAdded())
                    {
                        if (flow == null) { return; }
                        int first = flow.getFirstVisibleCell().getIndex();
                        int last = flow.getLastVisibleCell().getIndex();
                        int selected = tableView.getSelectionModel().getSelectedIndex();

                        if (selected < first || selected > last)
                        {
                            flow.show(selected);
                        }
                    }
                }
            }
        });
    }

    public class Country
    {
        private SimpleStringProperty name;
        private SimpleStringProperty capital;

        public Country(String name, String capital)
        {
            this.name = new SimpleStringProperty(name);
            this.capital = new SimpleStringProperty(capital);
        }

        public SimpleStringProperty nameProperty() { return name; }
        public SimpleStringProperty capitalProperty() { return capital; }
    }
}