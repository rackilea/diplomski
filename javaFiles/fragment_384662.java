public class Person {
    private String name;
    private PropertyChangeSupport _changeSupport;

    public Person() {
        _changeSupport = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        final String prev = this.name;
        this.name = name;
        _changeSupport.firePropertyChange("name", prev, name);
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        _changeSupport.addPropertyChangeListener(listener);
    }
}