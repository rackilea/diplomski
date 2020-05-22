box.setConverter(new StringConverter<ComboBoxItem>() {

        @Override
        public String toString(ComboBoxItem object) {
            return object == null ? null : object.toString();
        }

        @Override
        public ComboBoxItem fromString(String string) {
            return box.getItems().stream().filter(item -> item.text.equals(string)).findFirst().orElse(null);
        }
    });