public void fireTableChanged(TableModelEvent e) {
    // Guaranteed to return a non-null array
    Object[] listeners = listenerList.getListenerList();
    // Process the listeners last to first, notifying
    // those that are interested in this event
    for (int i = listeners.length-2; i>=0; i-=2) {
        if (listeners[i]==TableModelListener.class) {
            ((TableModelListener)listeners[i+1]).tableChanged(e);
        }
    }
}