button.disableProperty().bind(Bindings.createBooleanBinding(
    () -> {
        if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
            return true;
        }
        return !(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected());
    },
    textField1.textProperty(), textField1.textProperty(), checkBox1.selectedProperty(), checkBox2.selectedProperty(), checkBox3.selectedProperty()
));