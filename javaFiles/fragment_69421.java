class Test1<T extends Number> { ... }
class Test2<T> extends Number { ... }

Test1<Integer> a1 = new Test1<>();  // OK.
Test2<Integer> a2 = new Test2<>();  // OK.

Test1<Object> b1 = new Test1<>();   // Compiler error: Object not in bounds.
Test2<Object> b2 = new Test2<>();   // OK - T isn't bounded.

Number c1 = new Test1<Integer>();   // Compiler error: a Test1 isn't a Number.
Number c2 = new Test2<Integer>();   // OK.