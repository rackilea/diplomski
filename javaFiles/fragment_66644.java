public interface X<T> {
    Map<DateTime, Map<String, T>> getData();
}

public class A implements X<CustomObjectA> {
    @Override
    public Map<DateTime, Map<String, CustomObjectA>> getData() {
        ...
    }
}

public class B implements X<CustomObjectB> {
    @Override
    public Map<DateTime, Map<String, CustomObjectB>> getData() {
        ...
    }
}

public class C {
    public static void main(String[] args) {
        X<CustomObjectA> a = new A();
        Map<DateTime, Map<String, CustomObjectA>> m1 = a.getData();
        X<CustomObjectB> b = new B();
        Map<DateTime, Map<String, CustomObjectB>> m2 = b.getData();
    }
}