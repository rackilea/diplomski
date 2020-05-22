protected transient PropertyChangeSupport changeSupport = null;

public void addPropertyChangeListener (String propertyName, PropertyChangeListener listener)
{
    if (changeSupport == null)
        changeSupport = new PropertyChangeSupport (this);

    changeSupport.addPropertyChangeListener (propertyName, listener);
}

public void firePropertyChange (String propertyName, BigDecimal oldValue, BigDecimal newValue)
{
    if (changeSupport == null)
        return;

    if (oldValue != null && newValue != null && oldValue.compareTo (newValue) == 0) {
        return;
    }
    changeSupport.firePropertyChange(new PropertyChangeEvent(this, propertyName,
                                               oldValue, newValue));
}