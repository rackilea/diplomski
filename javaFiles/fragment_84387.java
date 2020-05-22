ChangeListener<String> listener = new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
        textField.setStyle("-fx-border-color:black");
        textField.textProperty().removeListener(this); 
    }
};
textField.textProperty().addListener(listener);