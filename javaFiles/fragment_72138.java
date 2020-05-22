final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
             this.pcs.addPropertyChangeListener(listener);
    }


      boolean connected;

 public boolean isConnected() {
     return connected;
 }

 public void setConnected(boolean connected) {
     boolean oldValue = this.connected;
     this.value = connected;
     this.pcs.firePropertyChange("connected", oldValue, newValue);
 }

 .....


     public Client(String hostname, int port) throws UnknownHostException, IOException    {
    connection = new Socket(hostname, port);
    setConnected(connection != null && !connection.isClosed());
}