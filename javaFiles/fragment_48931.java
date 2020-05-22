interface A { 
    default void foo() { ... }
}

interface B { 
}

class C implements A, B { 
}