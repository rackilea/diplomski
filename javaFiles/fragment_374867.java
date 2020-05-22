public abstract class AbstractNumberModel implements NumberModel {

    private List<ChangeListener> listeners;

    public AbstractNumberModel() {
        listeners = new ArrayList<>(25);
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    protected ChangeListener[] getChangeListeners() {
        // FIFO...
        List<ChangeListener> copy = new ArrayList<>(listeners);
        Collections.reverse(copy);
        return copy.toArray(copy.toArray(new ChangeListener[listeners.size()]));
    }

    protected void fireStateChanged() {
        ChangeListener[] listeners = getChangeListeners();
        if (listeners != null && listeners.length > 0) {
            ChangeEvent evt = new ChangeEvent(this);
            for (ChangeListener listener : listeners) {
                listener.stateChanged(evt);
            }
        }
    }
}