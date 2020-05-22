interface Z {
     abstract boolean foo();
}

abstract class A implements Z {

}

interface B extends Z {
     default boolean foo() { return doBlah(); }
}

class C extends A implements B {

}