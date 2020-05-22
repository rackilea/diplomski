public class Model {

    private ArrayList<Tile> list = new ArrayList<Tile>();
    private List<ModelListener> listeners = new ArrayList<>(25);

    public Model() {
    }

    public void addModelListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void removeModelListener(ModelListener listener) {
        listeners.remove(listener);
    }

    protected void fireTileRemoved(Tile tile) {
        for (ModelListener listener : listeners) {
            listener.tileWasRemoved(tile);
        }
    }

    public void removeByChar(char value) {
        Iterator<Tile> iterator = list.iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            if (value == tile.getChar()) {
                fireTileRemoved(tile);
                iterator.remove();
            }
        }
    }

    private void add(Tile tile) {
        list.add(tile);
    }

    private Iterable<Tile> getTiles() {
        return Collections.unmodifiableList(list);
    }
}