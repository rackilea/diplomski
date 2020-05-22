/** Class with a non-default constructor and no-default constructor. */
public class A {
    private int value;

    /** No-arg constructor */
    public A() { 
        this.value = 0;
    }

    /** Non-default constructor */
    public A(int value) { 
        this.value = value;
    }

    public int getValue() { 
        return this.value;
    }
}

/** Class that has a method that returns a reference to A using an anonymous inner class that inherits from A. */
public class B {
    public B() { ; }

    /** Returns reference of class A using anonymous inner class inheriting from A */
    public A getReference() {
         return new A(5) {
              public int getValue() {
                  return super.getValue() * 2;
              }
         };
    }
}