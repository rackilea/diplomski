public class Blah implements InstanceCreator<Blah> {
    private final transient PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    ...

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public Blah createInstance(Type type) {
        return new Blah();
    }   
}