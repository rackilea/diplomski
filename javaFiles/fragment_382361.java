public class A1{

    boolean initialized = false;

    //constructor method
    public A1(...){...}

    //init method
    public void init()
    {
        // do init stuff
        initialized = true;
    }

    //some class specific method
    public void myMethod() { 
        if(!initialized) {
            // print error
        } else {
            // do your stuff
        }
    }
    ...
}