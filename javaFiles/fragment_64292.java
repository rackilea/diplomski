import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

// Obviously use a more sensible name for the class:
public class RowData {

    private final IntegerProperty firstValue = new SimpleIntegerProperty();
    private final IntegerProperty secondValue = new SimpleIntegerProperty();
    private final BooleanProperty includePause = new SimpleBooleanProperty();
    private final ReadOnlyIntegerWrapper total = new ReadOnlyIntegerWrapper();

    public RowData() {
        total.bind(Bindings.createIntegerBinding(() -> {
            int total = getFirstValue() + getSecondValue() ;
            if (isIncludePause()) {
                total += 10 ;
            }
            return total ;
        }, firstValue, secondValue, includePause));
    }

    public final IntegerProperty firstValueProperty() {
        return this.firstValue;
    }


    public final int getFirstValue() {
        return this.firstValueProperty().get();
    }


    public final void setFirstValue(final int firstValue) {
        this.firstValueProperty().set(firstValue);
    }


    public final IntegerProperty secondValueProperty() {
        return this.secondValue;
    }


    public final int getSecondValue() {
        return this.secondValueProperty().get();
    }


    public final void setSecondValue(final int secondValue) {
        this.secondValueProperty().set(secondValue);
    }


    public final BooleanProperty includePauseProperty() {
        return this.includePause;
    }


    public final boolean isIncludePause() {
        return this.includePauseProperty().get();
    }


    public final void setIncludePause(final boolean includePause) {
        this.includePauseProperty().set(includePause);
    }


    public final ReadOnlyIntegerProperty totalProperty() {
        return this.total.getReadOnlyProperty();
    }


    public final int getTotal() {
        return this.totalProperty().get();
    }

}