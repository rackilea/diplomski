public class CheckComboReadOnlySkin<T> extends CheckComboBoxSkin<T> {
    public CheckComboReadOnlySkin(CheckComboBox control) {
        super(control);

        ((ComboBox) getChildren().get(0)).setCellFactory((Callback<ListView<T>, ListCell<T>>) listView -> {
            CheckBoxListCell<T> result = new CheckBoxListCell<>(item -> control.getItemBooleanProperty(item));
            result.getStyleClass().add("readonly-checkbox-list-cell");
            result.setDisable(true);
            result.converterProperty().bind(control.converterProperty());
            return result;
        });
    }
}