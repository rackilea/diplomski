public class MyEvent extends EventObject {
    public MyEvent(Object source) {
        super(source);
    }
}

public interface MyEventListener {
    void handleEvent(EventObject event);
}

public class MyEventSource {
    private final List<MyEventListener> listeners;
    public MyEventSource() {
        listeners = new CopyOnWriteArrayList<MyEventListener>();
    }
    public void addMyEventListener(MyEventListener listener) {
        listeners.add(listener);
    }
    public void removeMyEventListener(MyEventListener listener) {
        listeners.remove(listener);
    }
    void fireEvent() {
        MyEvent event = new MyEvent(this);
        for (MyEventListener listener : listeners) {
            listener.handleEvent(event);
        }
    }
}