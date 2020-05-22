public interface ModelListener {
    public void modelCleared(Model model);
}

public class Model {

    private List<ModelListener> listeners;

    Model() {
        listeners = new ArrayList<>(25);
    }

    public void addModelListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void Clear() {
        System.out.print("HELP");
        for (ModelListener listener : listeners) {
            listener.modelCleared(this);
        }
    }
}