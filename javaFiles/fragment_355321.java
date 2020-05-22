interface genericInterface<E extends Comparable <E>> {
    E getKey();
}
class MyClass<T> implements genericInterface<Integer> {
    T getValue();
}

MyClass<String> m = new MyClass<String>();
Integer a = m.getKey(); // Because MyClass always has E = Integer
String b = m.getValue(); // Because m has T = String

genericInterface<Integer> g = new MyClass<Boolean>();
Integer c = g.getKey();