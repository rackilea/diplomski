import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewWithCheckBoxes extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<String> toppingsList = new ListView<>();
        String[] toppings = {"Cheese", "Tomato Sauce", "Pepperoni", "Black Olives"};
        toppingsList.getItems().addAll(toppings);

        ObservableSet<String> selectedToppings = FXCollections.observableSet();

        toppingsList.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(String item) {
                BooleanProperty observable = new SimpleBooleanProperty();
                observable.addListener((obs, wasSelected, isNowSelected) -> {
                    if (isNowSelected) {
                        selectedToppings.add(item);
                    } else {
                        selectedToppings.remove(item);
                    }
                    System.out.println(selectedToppings.size());

                });

                observable.set(selectedToppings.contains(item));
                selectedToppings.addListener((SetChangeListener.Change<? extends String> c) -> 
                    observable.set(selectedToppings.contains(item)));

                return observable;
            }
        }));


        // example of a button that changes what's selected in the list
        // This selects "Cheese" and "Tomato Sauce" and deselects everything else
        Button justCheese = new Button("Just a cheese pizza");
        justCheese.setOnAction(e -> {
            selectedToppings.clear();
            selectedToppings.add("Cheese");
            selectedToppings.add("Tomato Sauce");
        });

        BorderPane root = new BorderPane(toppingsList);
        root.setTop(justCheese);
        BorderPane.setMargin(justCheese, new Insets(5));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}