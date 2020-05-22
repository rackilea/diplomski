// Shared interface in client and server sides
 @ProxyFor(Foo.class)
 interface Foo extends ValueProxy {
    String getBar();
 }

 // Server side implementation
 class FooImpl implements Foo {
    String getBar(){return "bar";};
 }