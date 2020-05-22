public final class PubNubManager {
    private final List<WeakReference<PubNubListener>> listeners = new ArrayList<>();

    // Other standard singleton stuff

    public void informListeners(PubNubData data) {
        listeners.stream().forEach(listenerRef -> {
            if (listenerRef.get() != null)
                listenerRef.get().receiveData(data);
        });

        // You can remove weakreference that are no longer valid, or stop getting for data when there are no more listener.
    }

    public void registerListener(PubNubListener listener) {
        if (listener != null)
            listeners.add(new WeakReference<>(listener));
    }

    // You can make one to unregister too if you want.
}

public interface PubNubListener {
    void receiveData(PubNubData data);
}

public class ControllerA implements PubNubListener {
    @Override
    public void receiveData(PubNubData data) {
        // What you need to do
    }
}