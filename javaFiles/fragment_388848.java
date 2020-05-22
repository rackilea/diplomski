interface Foo {
    void bar();
} 
class UnsafeFoo implements Foo {
    @Override bar() { ... }
}
class ThreadSafeFoo implements Foo {
    Foo foo;
    ThreadSafeFoo(Foo foo) { this.foo = foo; } 
    @Override synchronized bar() { foo.bar(); }
}

Foo unsafe = new UnsafeFoo();
Foo safe = new ThreadSafeFoo(unsafe);