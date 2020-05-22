@Override
public void start(Stage primaryStage) {
    class Item {
        final int id;
        final String text;

        public Item(int id, String text) {
            this.id = id;
            this.text = text;
        }

    }

    ComboBox<Item> comboBox = new ComboBox<>();
    for (int i = 0; i < 26*2; i++) {
        comboBox.getItems().add(new Item(i, Character.toString((char) i % ('Z' - 'A' + 1) + 'A')));
    }

    class ItemCell extends ListCell<Item> {

        @Override
        protected void updateItem(Item item, boolean empty) {
            super.updateItem(item, empty);

            setText(item == null ? "" : item.text);
        }

    }

    comboBox.setCellFactory(lv -> new ItemCell());
    comboBox.setButtonCell(new ItemCell());

    comboBox.valueProperty().addListener((o, oldValue, newValue) -> {
        System.out.format("%02d: %s\n", newValue.id, newValue.text);
    });

    StackPane root = new StackPane(comboBox);

    Scene scene = new Scene(root, 300, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}