import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {

    class FermentableInRecipe {

        private DoubleProperty weight;

        public Double getWeight() {
            return this.weight.getValue();
        }

        public void setWeight(Double value) {
            this.weight.setValue(value);
        }

        public DoubleProperty WeightProperty() {
            if (weight == null) {
                weight = new SimpleDoubleProperty(0.0);
            }
            return weight;
        }

    }

    private ObservableList<FermentableInRecipe> fermentablesInRecipe = FXCollections.observableArrayList(item -> new Observable[]{item.WeightProperty()});

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
}