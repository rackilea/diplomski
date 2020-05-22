TextField tf = new TextField();
StringConverter<Number> converter = new StringConverter<Number>() {

    @Override
    public String toString(Number object) {
        return object == null ? "" : object.toString();
    }

    @Override
    public Number fromString(String string) {
        if (string == null) {
            return 0;
        } else {
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException ex) {
                return 0;
            }
        }
    }

};
IntegerProperty property = new SimpleIntegerProperty();
Bindings.bindBidirectional(tf.textProperty(), property, converter);