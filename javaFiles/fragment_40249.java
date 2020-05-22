ObservableList<String> strings = FXCollections.observableArrayList();
IntegerBinding sizeProperty = Bindings.size(strings);
BooleanBinding multipleElemsProperty = new BooleanBinding() {
    @Override protected boolean computeValue() {
        return strings.size() > 1;
    }
};