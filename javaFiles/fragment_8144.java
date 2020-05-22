class VocalInteger {

    private int value;
    private final Object lock = new Object();
    Set<VocalIntegerListener> listeners; // assume interface exists - it's easy


    public VocalInteger() {
        this(0);
    }

    public VocalInteger(int value) {
        this.value = value;
        listeners = new HashSet<VocalIntegerListener>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        synchronized(lock) {
            int oldValue = this.value;
            this.value = value;
            for(VocalIntegerListener listener : listeners) {
                listener.fireChangedEvent(oldvalue, value); // assume exists
            }
        }
    }

    public void registerListener(VocalIntegerListener listener) {
        synchronized(lock) {
            listeners.add(listener);
        }
    }
}