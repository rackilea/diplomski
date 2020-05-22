class Player {
    public static final int HEALTH_MIN = 0;
    public static final int HEALTH_MAX = 100;
    public static final String HEALTH = "health";
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    private String name;
    int health = 50; // value from 1 to 100

    public Player(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        int oldValue = this.health;
        int newValue = health;
        this.health = health;

        // notify observers of change
        pcSupport.firePropertyChange(HEALTH, oldValue, newValue);
    }

    public String getName() {
        return name;
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