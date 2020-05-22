<T> void f1(List<T> a){ ... }

<T> void f2(List<T> a1, List<T> a2){ ... }

List<?> a = ...;

f1(a); // compiles

f2(a, a); // does not compile