public class A {

    private static MyAPI instance = null;
    protected static Object lockForMyMethod = new Object(); //have a static lock

    // other methods    
}

public class B extends A {

    public void myMethod(){
        synchronized (A.lockForMyMethod) { //do not lock on A.class
            myAPI = getAPI();
            // do stuffs with myAPI
        }
    }
}