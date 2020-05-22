private void setButtonTextFieldListeners(Button button, TextField... textFields) {
    ChangeListener<String> listener = (observable, oldValue, newValue) -> {
        for (int i=0; i<textFields.length; i++) {
            if (textFields[i].getText()==null || textFields[i].getText().trim().isEmpty()) {
                button.setDisable(true);
                return;
            }
        }
        button.setDisable(false);
    }
    for (TextField textField : textFields) {
        textField.textProperty().addListener(listener);
    }
}