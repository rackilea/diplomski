abstract class A<T> {
    abstract void doSomething(T obj);
};

class B extends A<B> {

    @Override
    void doSomething(B obj) {
    }

};

class C extends A<C> {

    @Override
    void doSomething(C obj) {
    }

};