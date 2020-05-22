private void deselect(TextField textField) {
    Platform.runLater(() -> {
        if (textField.getText().length() > 0 &&
                textField.selectionProperty().get().getEnd() == 0) {
            deselect(textField);
        }else{
            textField.selectEnd();
            textField.deselect();
        }
    });
}