public static final <T> PropertyEditor<?> createCheckBoxLinkEditor(PropertySheet.Item property,
        final Collection<T> choices) {
    ComboBox<T> comboBox = new ComboBox<T>();
    comboBox.setCellFactory((ListView<T> p) -> new ListCell<T>() {
        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
            } else if (item instanceof Class) {
                setText(((Class) item).getSimpleName());
            } else {
                setText(item.toString());
            }
        }
    });
    HBox hbox = new HBox(5);
    CheckBox checkBox = new CheckBox();
    hbox.getChildren().add(checkBox);
    hbox.getChildren().add(comboBox);
    //hbox.getA
    //comboBox.setConverter(value);
    return new AbstractPropertyEditor<T, HBox>(property, hbox) {

        {
            comboBox.setItems(FXCollections.observableArrayList(choices));
            //new AutoCompleteComboBoxListener(comboBox);
            new SelectKeyComboBoxListener(comboBox);
        }

        @Override
        protected ObservableValue<T> getObservableValue() {
            return comboBox.getSelectionModel().selectedItemProperty();
        }

        @Override
        public void setValue(T value) {
            comboBox.getSelectionModel().select(value);
        }
    };
}