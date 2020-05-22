class MyClass {
    private final Object lock = new Object();
    private Channel channel = null;

    public void setChannel() {
        // other code can go here

        synchronized (lock) {
            channel = new Channel();
            // setup channel
        }

        // other code can go here
    }

    public void unsetChannel() {

        // other code can go here

        synchronized (lock) {
            channel.close();
            channel = null;
        }

        // other code can go here
    }

    public boolean isSet() {
        synchronized (lock) {
            if (channel == null) {
                return false;
            }
            return channel.isActive();
        }
    }
}