public class Attached {

    public static enum State {
        NEW, ATTACHED, REMOVED
    }

    private final ObjectProperty<State> state = new SimpleObjectProperty<>();
    private final StringProperty path = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();

    public Attached(State state, String path, String name) {
        setState(state);
        setPath(path);
        setName(name);
    }

    public ObjectProperty<State> stateProperty() {
        return state ;
    }

    public final State getState() {
        return stateProperty().get();
    }

    public final void setState(State state) {
       stateProperty().set(state);
    }

    public StringProperty pathProperty() {
        return path ;
    }

    public final String getPath() {
        return pathProperty.get();
    }

    public final void setPath(String path) {
        pathProperty().set(path);
    }

    public StringProperty nameProperty() {
        return name ;
    }

    public final String getName() {
        return nameProperty().get();
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    @Override
    public String toString() {
        return getName();
    }

}