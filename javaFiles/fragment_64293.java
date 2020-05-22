import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RowDataView {

    private final TextField firstValueField ;
    private final TextField secondValueField ;
    private final CheckBox includePauseBox ;
    private final TextField totalField ;

    public RowDataView(RowData data) {

        firstValueField = new TextField();
        bindToStringProperty(data.firstValueProperty(), firstValueField.textProperty());

        secondValueField = new TextField();
        bindToStringProperty(data.secondValueProperty(), secondValueField.textProperty());

        includePauseBox = new CheckBox();
        data.includePauseProperty().bind(includePauseBox.selectedProperty());

        totalField = new TextField();
        totalField.setEditable(false);
        totalField.textProperty().bind(data.totalProperty().asString());
    }

    public void addToGridPane(GridPane pane, int row, int firstValueColumn, int secondValueColumn, int checkboxColumn, int totalColumn) {
        pane.add(firstValueField, firstValueColumn, row);
        pane.add(secondValueField, secondValueColumn, row);
        pane.add(includePauseBox, checkboxColumn, row);
        pane.add(totalField, totalColumn, row);
    }

    public void addToGridPane(GridPane pane, int row, int column) {
        addToGridPane(pane, row, column, column+1, column+2, column+3);
    }

    public void addToGridPane(GridPane pane, int row) {
        addToGridPane(pane, row, 0);
    }

    private void bindToStringProperty(IntegerProperty p, StringProperty s) {
        p.bind(Bindings.createIntegerBinding(
                () -> {
                    if (s.get().matches("\\d+")) {
                        return Integer.parseInt(s.get());
                    }
                    return 0 ;
                }, s));
    }
}