public class MyListeningClass implements MyListener {

    public MyListeningClass() {
        MyClass myClass = ...get the MyClass object from somewhere...;
        myClass.setMyListener(this);
    }

    // this is called by MyClass when the event occurs
    public void myEventFired(Object sender, MyEventArgs eventArgs) {
        System.out.println("EVENT HAPPENED!");
        System.out.println("Sender is: "+sender);
        System.out.println("MyEventArgs are: "+eventArgs);
    }    
}