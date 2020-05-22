import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AddingModel {

    private final ObservableList<Integer> values = FXCollections.observableArrayList();

    private final ReadOnlyIntegerWrapper total = new ReadOnlyIntegerWrapper();

    public AddingModel() {
        total.bind(Bindings.createIntegerBinding(() -> 
            values.stream().collect(Collectors.summingInt(Integer::intValue)), 
            values));
    }

    private void ensureFXThread(Runnable action) {
        if (Platform.isFxApplicationThread()) {
            action.run();
        } else {
            Platform.runLater(action);
        }
    }

    public void clear() {
        ensureFXThread(values::clear);
    }

    public void addValue(int value) {
        ensureFXThread(() -> values.add(value));
    }

    public final ReadOnlyIntegerProperty totalProperty() {
        return this.total.getReadOnlyProperty();
    }


    public final int getTotal() {
        return this.totalProperty().get();
    }


    public ObservableList<Integer> getValues() {
        return values ;
    }
}