TextField tf = new TextField();
StringConverter<Number> converter = new NumberStringConverter();

TextFormatter<Number> formatter = new TextFormatter<>(converter, 0);
tf.setTextFormatter(formatter);

IntegerProperty property = new SimpleIntegerProperty();
property.bindBidirectional(formatter.valueProperty());