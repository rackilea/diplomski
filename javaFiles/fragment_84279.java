public enum Type {
    IMPORT, EXPORT
}

public class WizardModel {

    private PropertyChangeSupport propertyChangeSupport;
    private Type type;

    public WizardModel() {
        super();
        this.type = Type.IMPORT;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type newType) {
        Type oldType = this.type;
        this.type = newType;
        firePropertyChangeEvent(new PropertyChangeEvent(this, "type", oldType, newType));
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    protected void firePropertyChangeEvent(PropertyChangeEvent evt) {
        for (PropertyChangeListener l : propertyChangeSupport.getPropertyChangeListeners(evt.getPropertyName())) {
            l.propertyChange(evt);
        }
    }
}