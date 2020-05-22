public interface PropertyChangeNotification {
    void addPropertyChangeListener(String property, PropertyChangeListener listener);
    void removePropertyChangeListener(String property, PropertyChangeListener listener);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
}