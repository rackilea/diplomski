public interface Inter<T extends Inter<T>> {

    T someMethod();
    void someMethod2(T obj);
}

public class C1 implements Inter<C1> {

    public C1 someMethod() {
        return new C1();
    }

    public void someMethod2(C1 obj) {
      // ..
    }
}

public class C2 implements Inter<C3> { // ERROR
    ..
}