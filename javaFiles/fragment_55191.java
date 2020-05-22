class CountModel {
    public static final String COUNT = "count"; // for count "property"

    // support object that will notify listeners of change
    private SwingPropertyChangeSupport support = new SwingPropertyChangeSupport(this);
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        int oldValue = this.count;
        int newValue = count;
        this.count = count;

        // notify listeners that count has changed
        support.firePropertyChange(COUNT, oldValue, newValue);
    }

    // two methods to allow listeners to register with support object
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

}