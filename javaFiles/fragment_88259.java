public interface MyInterface {
    public void foo();
    public void bar();
}

public class Super {
    public void foo() { System.out.println("foo"); }
}

public class Sub extends Super implements MyInterface {
    public void bar() { System.out.println("bar"); }
}