textField.textProperty().addListener((observable, oldValue, newValue) -> {
    // this code is called whenever the text in the field changes
    // oldValue is the text contained before the event was triggered
    // newValue is the text that the field is about to be set to

    if (oldValue.contains("[a-zA-Z]")) {  // any predicate you want/need
        textField.setText(oldValue);  // revert the text of the field back to its old value
    }
});