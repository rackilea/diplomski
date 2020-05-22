class Foo {}
class B<T extends Foo> {
    T f(T a) {
        return new Foo();
    }
}
class Bar extends Foo {}