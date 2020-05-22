public class Outer {
    public String out = "out";
    public Inner inner = new Inner();

    public class Inner {   
        public void printEnclosing() {
            System.out.println(Outer.this.out); // "out" can be safely referenced
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Inner inner = new Inner(); // Compile-time error

        Outer out = new Outer();
        out.inner.printEnclosing(); // This works, because you are calling method of the Inner class instance owned by Outer class.
    }
}