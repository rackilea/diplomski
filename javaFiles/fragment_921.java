// normal setup of spinner
SpinnerValueFactory factory = new IntegerSpinnerValueFactory(0, 10000, 0);
spinner.setValueFactory(factory);
spinner.setEditable(true);
// hook in a formatter with the same properties as the factory
TextFormatter formatter = new TextFormatter(factory.getConverter(), factory.getValue());
spinner.getEditor().setTextFormatter(formatter);
// bidi-bind the values
factory.valueProperty().bindBidirectional(formatter.valueProperty());