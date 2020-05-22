public class MySuperclass {
    public final void myExposedInterface() {
        //do the things you always want to have happen here

        overridableInterface();
    }

    protected void overridableInterface() {
        //superclass implemention does nothing
    }
}

public class MySubclass extends MySuperclass {
    @Override
    protected void overridableInterface() {
        System.out.println("Subclass-specific code goes here");
    }
}