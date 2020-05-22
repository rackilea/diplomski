public class BLEConnection {

    private ArrayList<BLEConnectionListener> listeners = new ArrayList<BLEConnectionListener>();

    public void addListener(BLEConnectionListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeListener(BLEConnectionListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void forwardStatusUpdate(String statusString) {
        for (BLEConnectionListener listener: listeners) {
            listener.statusUpdated(statusString);
        }
    }
}