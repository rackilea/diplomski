abstract class A {
    abstract Serializable getId();
}

abstract class B extends A {
    @Override
    abstract Number getId();
}

class C extends B {

    @Override
    Integer getId() {
        return 42;
    }

}