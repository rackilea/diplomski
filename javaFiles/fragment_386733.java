public interface Inter<T> {

    T someMethod();
    void someMethod2(T obj);

}

public class C1 implements Inter<C1> {

    public C1 someMethod() {
      // ..
    }

    public void someMethod2(C1 obj) {
      // ..
    }

}

public class C2 implements Inter<C2> {

    public C2 someMethod() {
      // ..
    }

    public void someMethod2(C2 obj) {
      // ..
    }

}