final Properties props = new Properties();
props.setProperty("key", "value");
props.store(outputStream, "Adding key=value");
TimerTask deletePropertyTask = new TimerTask() {
    public void run() {
        props.remove("key");
        props.store(outputStream, "Removing key");
    }
};
new Timer().schedule(deletePropertyTask, 3000L); // fire in 3 seconds