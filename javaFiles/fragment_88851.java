public class MyClass {

    // declare it here
    private MulticastSocket socket;

    public MyClass() {
        // instantiate it here
        socket = new MulticastSocket(1201); 
    }

    public void myMethod() {
        // now you can use it everywhere!
        socket.someMethod();
    }

}