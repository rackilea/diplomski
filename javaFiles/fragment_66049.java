package com.client;         // not in the same package of `Foo`

class Client {              // not a subclass of `Foo`
    Foo foo = new Foo();    // possible because `Foo` is world-visible
    public int foobar() {
        return foo.bar;     // possible because `bar` is world-visible
    }
}