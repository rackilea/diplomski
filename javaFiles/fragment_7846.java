public class AsyncBinding<T> implements ObservableValue<T> {

    private ObservableValue<T> value;
    private InvalidationListener invalidationListener;
    private ChangeListener<T> changeListener;
    private List<InvalidationListener> invalidationListeners = new ArrayList<InvalidationListener>(
            1);
    private List<ChangeListener<? super T>> changeListeners = new ArrayList<ChangeListener<? super T>>(
            1);

    public static <T> ObservableValue<T> bind(ObservableValue<T> toWrap) {
        return new AsyncBinding<T>(toWrap);
    }

    private AsyncBinding(ObservableValue<T> value) {
        this.value = value;
        invalidationListener = new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Runnable fire = () -> {
                    synchronized (invalidationListeners) {
                        for (InvalidationListener listener : invalidationListeners) {
                            listener.invalidated(observable);
                        }
                    }
                };
                if (Platform.isFxApplicationThread()) {
                    fire.run();
                } else {
                    Platform.runLater(fire);
                }
            }
        };
        value.addListener(invalidationListener);

        changeListener = new ChangeListener<T>() {
            @Override
            public void changed(ObservableValue<? extends T> observable,
                    T oldValue, T newValue) {
                Runnable fire = () -> {
                    synchronized (changeListeners) {
                        for (ChangeListener<? super T> listener : changeListeners) {
                            listener.changed(observable, oldValue, newValue);
                        }
                    }
                };
                if (Platform.isFxApplicationThread()) {
                    fire.run();
                } else {
                    Platform.runLater(fire);
                }
            }
        };

        value.addListener(changeListener);
    }

    @Override
    public void addListener(InvalidationListener listener) {
        invalidationListeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        invalidationListeners.remove(listener);
    }

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        changeListeners.add(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        changeListeners.remove(listener);
    }

    @Override
    public T getValue() {
        return value.getValue();
    }
}