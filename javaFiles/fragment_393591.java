public class ComboLoader {

    private ObservableList<Item> obsItems;

    public ComboLoader() {

        obsItems = FXCollections.observableArrayList(createItems());
    }

    private List<Item> createItems() {
            return IntStream.rangeClosed(0, 5)
                    .mapToObj(i -> "Item "+i)
                    .map(Item::new)
                    .collect(Collectors.toList());
    }
    //name of this methods corresponds to itemLoader.items in fxml.
    //if xml name was itemLoader.a this method should have been
    //getA(). A bit odd 
    public ObservableList<Item> getItems(){

        return obsItems;
    }

    public static class Item {

        private final StringProperty name = new SimpleStringProperty();

        public Item(String name) {
            this.name.set(name);
        }

        public final StringProperty nameProperty() {
            return name;
        }

        @Override
        public String toString() {
            return name.getValue();
        }
    }
}