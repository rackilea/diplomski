class Player {
    public static final String HEALTH = "health"; // the name of the property of interest
    public static final int HEALTH_MIN = 0;
    public static final int HEALTH_MAX = 100;
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    private String name;
    int health = 50; // value from 1 to 100

    public Player(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    // any time this is called, listeners will be notified through the pcSupport object
    public void setHealth(int health) {
        int oldValue = this.health;
        int newValue = health;
        this.health = health;

        // notify observers of change in the HEALTH property
        pcSupport.firePropertyChange(HEALTH, oldValue, newValue);
    }

    public String getName() {
        return name;
    }

    // allow listeners/observers to be added
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

    // ....... other methods

}