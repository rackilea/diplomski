public class BasicDataSet {
    private final ReadOnlyStringWrapper name = new ReadOnlyStringWrapper();
    private final ReadOnlyStringWrapper tagName = new ReadOnlyStringWrapper();
    private final ObservableMap<String, String> dataPoints =
        FXCollections.observableHashMap();

    private final ObservableSet<String> keys =
        FXCollections.observableSet();

    public BasicDataSet(String name,
                        String tagName) {

        this.name.set(name);
        this.tagName.set(tagName);

        dataPoints.addListener(
            (MapChangeListener.Change<? extends String, ? extends String> c) -> {
            if (c.wasRemoved()) {
                keys.remove(c.getKey());
            }
            if (c.wasAdded()) {
                keys.add(c.getKey());
            }
        });
    }

    public ReadOnlyStringProperty nameProperty() {
        return name.getReadOnlyProperty();
    }

    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty tagNameProperty() {
        return tagName.getReadOnlyProperty();
    }

    public String getTagName() {
        return tagName.get();
    }

    public ObservableMap<String> getObservableDataPoints() {
        return dataPoints;
    }

    public ObservableSet<String> getDataPointKeys() {
        return keys;
    }

    public StringBinding getObservableDataPoint(String key) {
        return Bindings.stringValueAt(dataPoints, key);
    }

    public String getDataPoint(String key) {
        return getObservableDataPoint(key).get();
    }
}