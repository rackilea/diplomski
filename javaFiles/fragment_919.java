/**
 * c&p from Spinner
 */
private <T> void commitEditorText(Spinner<T> spinner) {
    if (!spinner.isEditable()) return;
    String text = spinner.getEditor().getText();
    SpinnerValueFactory<T> valueFactory = spinner.getValueFactory();
    if (valueFactory != null) {
        StringConverter<T> converter = valueFactory.getConverter();
        if (converter != null) {
            T value = converter.fromString(text);
            valueFactory.setValue(value);
        }
    }
}

// useage in client code
spinner.focusedProperty().addListener((s, ov, nv) -> {
    if (nv) return;
    //intuitive method on textField, has no effect, though
    //spinner.getEditor().commitValue(); 
    commitEditorText(spinner);
});