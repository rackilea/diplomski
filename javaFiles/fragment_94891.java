import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ListViewWithCheckBoxes extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<Topping> toppingsList = new ListView<>();
        Topping cheese = new Topping("Cheese");
        Topping tomSauce = new Topping("Tomato Sauce");
        Topping pepperoni = new Topping("Pepperoni");
        Topping blackOlives = new Topping("Black Olives");

        toppingsList.getItems().addAll(cheese, tomSauce, pepperoni, blackOlives);


        toppingsList.setCellFactory(CheckBoxListCell.forListView(Topping::selectedProperty));

        // example of a button that changes what's selected in the list
        // This selects "Cheese" and "Tomato Sauce" and deselects everything else

        Button justCheese = new Button("Just a cheese pizza");
        List<Topping> cheesePizzaToppings = Arrays.asList(cheese, tomSauce);

        justCheese.setOnAction(e -> toppingsList.getItems().forEach(
                topping -> topping.setSelected(cheesePizzaToppings.contains(topping))));

        BorderPane root = new BorderPane(toppingsList);
        root.setTop(justCheese);
        BorderPane.setMargin(justCheese, new Insets(5));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Topping {

        private final String name ;

        private final BooleanProperty selected = new SimpleBooleanProperty();

        public Topping(String name) {
            this.name = name ;
        }

        public BooleanProperty selectedProperty() {
            return selected ;
        }

        public final boolean isSelected() {
            return selectedProperty().get();
        }

        public final void setSelected(boolean selected) {
            selectedProperty().set(selected);
        }

        public String getName() {
            return name ;
        }

        @Override
        public String toString() {
            return getName();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}