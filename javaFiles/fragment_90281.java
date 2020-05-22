public class Parent {

    public void method() {

    }

    // OR

    public abstract void method(); // and make the class abstract as well
}

public class Child_A extends Parent {

    @Override
    public void method() {
        //do something useful
    }
}

// same with Child_B