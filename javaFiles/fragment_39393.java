public LabeledColorPickerSkin(final LabeledColorPicker colorPicker) {
    super(colorPicker);
    registerChangeListener(colorPicker.valueProperty(), observable -> {
        /* Some logic for updating the GUI */
    });
    text.setText(colorPicker.text);
    updateColor();
}