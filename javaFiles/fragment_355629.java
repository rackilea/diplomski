private static class Item {

    private final IntegerProperty value = new SimpleIntegerProperty();
}

private final ObservableMap<Item, Long> markTimes = FXCollections.observableHashMap();
private AnimationTimer updater;

private void updateValue(Item item, int newValue) {
    int oldValue = item.value.get();
    if (newValue != oldValue) {
        item.value.set(newValue);

        // update time of item being marked
        markTimes.put(item, System.nanoTime());

        // timer for removal of entry
        updater.start();
    }
}

@Override
public void start(Stage primaryStage) {
    Item item = new Item(); // the item that is updated
    TableView<Item> table = new TableView<>();
    table.getItems().add(item);

    // some additional items to make sure scrolling effects can be tested
    IntStream.range(0, 100).mapToObj(i -> new Item()).forEach(table.getItems()::add);

    TableColumn<Item, Number> column = new TableColumn<>();
    column.getStyleClass().add("mark-column");
    column.setCellValueFactory(cd -> cd.getValue().value);
    table.getColumns().add(column);

    final PseudoClass marked = PseudoClass.getPseudoClass("marked");

    table.setRowFactory(tv -> new TableRow<Item>() {

        final InvalidationListener reference = o -> {
            pseudoClassStateChanged(marked, !isEmpty() && markTimes.containsKey(getItem()));
        };
        final WeakInvalidationListener listener = new WeakInvalidationListener(reference);

        @Override
        protected void updateItem(Item item, boolean empty) {
            boolean wasEmpty = isEmpty();
            super.updateItem(item, empty);

            if (empty != wasEmpty) {
                if (empty) {
                    markTimes.removeListener(listener);
                } else {
                    markTimes.addListener(listener);
                }
            }

            reference.invalidated(null);
        }

    });

    Scene scene = new Scene(table);
    scene.getStylesheets().add("style.css");
    primaryStage.setScene(scene);
    primaryStage.show();

    updater = new AnimationTimer() {

        @Override
        public void handle(long now) {
            for (Iterator<Map.Entry<Item, Long>> iter = markTimes.entrySet().iterator(); iter.hasNext();) {
                Map.Entry<Item, Long> entry = iter.next();

                if (now - entry.getValue() > 2_000_000_000L) { // remove after 1 sec
                    iter.remove();
                }
            }

            // pause updates, if there are no entries left
            if (markTimes.isEmpty()) {
                stop();
            }
        }
    };

    final Random random = new Random();

    Thread t = new Thread(() -> {

        while (true) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                continue;
            }
            Platform.runLater(() -> {
                updateValue(item, random.nextInt(4));
            });
        }
    });
    t.setDaemon(true);
    t.start();
}