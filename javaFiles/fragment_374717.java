// parent
public class A {
    private int value = 0;
    public A( int initialValue ) {
        value = initialValue;
    }

    public void print() {
        System.out.println(value);
    }
}

// child class
public class B extends A {
    public B() {
       super( 1 );
    }
}