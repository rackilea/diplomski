public class MyClass {

    private MyListener listener = null;

    // This is a method which sometimes fires an event, by calling the fireEvent() method below
    public void doSomething() {
        ...
        if (something) {
            // Let's say the event happens if "something" is true. 
            // So now we "fire the event". What "firing the event" means, 
            // is just to call the "myEventFired" method in the listener.
            fireEvent();
        }
        ...

    }

    // this is called from the method above to fire the event - i.e. to tell the listener that the event has happened
    protected void fireEvent() {
        if (listener != null) {
            Object sender = this; 
            MyEventArgs eventArgs = new MyEventArgs(...something...);
            listener.myEventFired(sender, eventArgs);
        }
    }

    // This method is called by the listener, to register itself as listener on this object.
    // MyClass remembers the listener in the "listener" instance variable, so that 
    // when the event happens at some later point in time, it knows which object it  
    // has to tell it to.
    public void setMyListener(MyListener listener) {
        this.listener = listener;
    }
}