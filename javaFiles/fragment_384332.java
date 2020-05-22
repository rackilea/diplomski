List<?> a = ...;

f2_1(a); // compiles

<T> void f2_1(List<T> a){ f2_2(a,a); } // compiles, two a's same type: List<T>

<T> void f2_2(List<T> a1, List<T> a2){ ... }