class Foo {
    public Foo(String bar) {
        System.out.println("bar = " + bar);
    }
}

Class<?> fooCls = Class.forName("Foo");
Constructor<?> fooCtor = fooCls.getConstructor(String.class);
Foo foo = (Foo) fooCtor.newInstance("BAR");