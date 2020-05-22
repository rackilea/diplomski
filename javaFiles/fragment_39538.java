public class DoubleSpinnerCell<T> extends TableCell<T, Number> {
    private final Spinner<Double> spinner = new Spinner​(0, Double.MAX_VALUE, 0, 0.01);
    private boolean ignoreUpdate; // flag preventing updates triggered from ui/initialisation

    {
        spinner.valueProperty().addListener((o, oldValue, newValue) -> {
            if (!ignoreUpdate) {
                ignoreUpdate = true;
                WritableValue<Number> property = (WritableValue<Number>) getTableColumn().getCellObservableValue((T) getTableRow().getItem());
                property.setValue(newValue);
                ignoreUpdate = false;
            }
        });
    }


    @Override
    protected void updateItem(Number item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            ignoreUpdate = true;
            spinner.getValueFactory().setValue(item.doubleValue());
            setGraphic(spinner);
            ignoreUpdate = false;
        }
    }
}