public class MapKeyBinding<K> extends SetBinding<K> {

    private final ObservableSet<K> readonlyView;

    public <V> MapKeyBinding(ObservableMap<K, V> map) {
        ObservableSet<K> set = FXCollections.observableSet();
        set.addAll(map.keySet());
        readonlyView = FXCollections.unmodifiableObservableSet(set);
        map.addListener((MapChangeListener.Change<? extends K, ? extends V> change) -> {
            if (change.wasAdded() != change.wasRemoved()) {
                if (change.wasRemoved()) {
                    set.remove(change.getKey());
                } else {
                    set.add(change.getKey());
                }
            }
        });
    }

    @Override
    protected ObservableSet<K> computeValue() {
        return readonlyView;
    }

}