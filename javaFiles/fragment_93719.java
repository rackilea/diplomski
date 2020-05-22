public class Test {
    public static void main(String args[]) {
        new Bar();
    }
}

public class Foo {
    public Foo() { runMe(); }
    public void runMe() { System.out.println("Foo"); }
}

public class Bar extends Foo {
    public void runMe() { System.out.println("Bar");}
}