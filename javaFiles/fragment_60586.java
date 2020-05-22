public class MvcModel {
    public static final String SPEED = "speed";
    public static final String BATTERY = "battery";
    public static final int MAX_SPEED = 40;
    private float speed;
    private int batteryPercentage;
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        float oldValue = this.speed;
        float newValue = speed;
        this.speed = speed;
        pcSupport.firePropertyChange(SPEED, oldValue, newValue);
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        int oldValue = this.batteryPercentage;
        int newValue = batteryPercentage;
        this.batteryPercentage = batteryPercentage;
        pcSupport.firePropertyChange(BATTERY, oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(name, listener);
    }

}