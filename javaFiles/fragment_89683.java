static class Item {
    private final String full, part;

    public Item(String full, String part) {
        this.full = full;
        this.part = part;
    }

    public String getFull() {
        return full;
    }

    public String getPart() {
        return part;
    }

}

@Override
public void start(Stage primaryStage) {
    ComboBox<Item> comboBox = new ComboBox<>(FXCollections.observableArrayList(
            new Item("AB", "A"),
            new Item("CD", "C")
    ));

    comboBox.setEditable(true);

    // use short text in textfield
    comboBox.setConverter(new StringConverter<Item>(){

        @Override
        public String toString(Item object) {
            return object == null ? null : object.getPart();
        }

        @Override
        public Item fromString(String string) {
            return comboBox.getItems().stream().filter(i -> i.getPart().equals(string)).findAny().orElse(null);
        }

    });

    comboBox.setCellFactory(lv -> new ListCell<Item>() {

        @Override
        protected void updateItem(Item item, boolean empty) {
            super.updateItem(item, empty);

            // use full text in list cell (list popup)
            setText(item == null ? null : item.getFull());
        }

    });

    Scene scene = new Scene(comboBox);

    primaryStage.setScene(scene);
    primaryStage.show();
}