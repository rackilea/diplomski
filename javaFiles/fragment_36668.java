class Foo<T>
{
    Foo(Class<T> clazz){}
}

Foo<String> foo1 = new Foo(Integer.class);    // compiles (wrongly) 

Foo<String> foo2 = new Foo<>(Integer.class);  // does not compile