userName.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
    if (!newValue) {
        if(userName.validate()) userName.setDisable(false);
        else userName.setDisable(true);
    }
});