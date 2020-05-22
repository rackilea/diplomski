public interface A {
}

public class B implements A {
}

public class C {
    public static void main(String args[]) {
        A obj = new B();
    }
}