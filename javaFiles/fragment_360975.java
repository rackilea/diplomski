enum Foo {
    INSTANCE;
}

Class<?> fooClass = Foo.class;
Constructor<?> c = fooClass.getDeclaredConstructors()[0];
c.setAccessible(true);
Foo f = (Foo)c.newInstance();