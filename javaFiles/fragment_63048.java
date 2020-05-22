import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class UI {

    private final TextArea textArea ;
    private final Parent view ;
    private long total ;
    private long count ;
    private final DoubleProperty average = new SimpleDoubleProperty(0);


    public UI() {
        textArea = new TextArea();

        Label aveLabel = new Label();
        aveLabel.textProperty().bind(average.asString("Average: %.3f"));

        view = new BorderPane(textArea, null, null, aveLabel, null);
    }

    public void registerData(MyDataClass data) {
        textArea.appendText(String.format("Data: %d (received %.3f milliseconds after generation)%n", 
                data.getValue(), data.age()/1_000_000.0)); 
        count++;
        total+=data.getValue();
        average.set(1.0*total / count);
    }

    public Parent getView() {
        return view ;
    }
}