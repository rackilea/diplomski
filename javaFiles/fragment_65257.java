@FXML
private void initialize() {

// Listen for selection changes
yourTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CarObject>() {

        @Override
        public void changed(ObservableValue<? extends CarObject> observable,
                CarObject oldValue, CarObject newValue)
        {
                 carToDelete = newValue;
        }
    });
}