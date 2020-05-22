ts.currentKeyProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> observable, 
                                    Number oldValue, Number newValue) {
        label.setText(newValue);
        // do other stuff according to "oldValue" and "newValue".
    }
});