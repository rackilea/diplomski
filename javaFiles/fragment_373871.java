import java.util.stream.IntStream;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleCheckBoxSelection extends Application {

    private BooleanBinding allSelected ;

    @Override
    public void start(Stage primaryStage) {
        CheckBox selectAll = new CheckBox("Select all");
        int numBoxes = 5 ;
        CheckBox[] boxes = IntStream
                .rangeClosed(1,  numBoxes)
                .mapToObj(i -> new CheckBox("Item "+i))
                .toArray(CheckBox[]::new);

        bindPanelToPackages(selectAll, boxes);


        VBox root = new VBox(10, selectAll);
        root.setStyle("-fx-padding: 15;");
        Stream.of(boxes).forEach(box -> box.setStyle("-fx-padding: 0 0 0 10;"));
        Stream.of(boxes).forEach(root.getChildren()::add);
        Scene scene = new Scene(root, 250, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void bindPanelToPackages(CheckBox pane, CheckBox... packages) {

        // BooleanBinding that is true if and only if all check boxes in packages are selected:
        allSelected = Bindings.createBooleanBinding(() -> 
            // compute value of binding:
            Stream.of(packages).allMatch(CheckBox::isSelected), 
            // array of thing to observe to recompute binding - this gives the array
            // of all the check boxes' selectedProperty()s.
            Stream.of(packages).map(CheckBox::selectedProperty).toArray(Observable[]::new));

        // update pane's selected property if binding defined above changes
        allSelected.addListener((obs, wereAllSelected, areAllNowSelected) -> 
            pane.setSelected(areAllNowSelected));

        // use an action listener to listen for a direct action on pane, and update all checkboxes
        // in packages if this happens:
        pane.setOnAction(e -> 
            Stream.of(packages).forEach(box -> box.setSelected(pane.isSelected())));

    }

    public static void main(String[] args) {
        launch(args);
    }
}