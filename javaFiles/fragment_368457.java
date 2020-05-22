public void addChangeListener(ChangeListener listener) {
    listenerList.add(ChangeListener.class, listener);
}

public void removeChangeListener(ChangeListener listener) {
    listenerList.remove(ChangeListener.class, listener);
}

public ChangeListener[] getChangeListeners() {
    return listenerList.getListeners(ChangeListener.class);
}

protected void fireChangeListeners() {
    ChangeEvent event = new ChangeEvent(this);
    for (ChangeListener listener : getChangeListeners()) {
        listener.stateChanged(event);
    }
}