class Foo {

}

interface A {
    public void a();
}

interface B {
    public void b();
}

class ImplA implements A {
    @Override
    public void a() {
        System.out.println("a");
    }
}

class ImplB implements B {
    @Override
    public void b() {
        System.out.println("b");
    }
}

class Bar extends Foo {
    A a = new ImplA();

    public void a() {
        a.a();
    }
}

class Baz extends Foo {
    B b = new ImplB();

    public void b() {
        b.b();
    }       
}

class Qux extends Foo {

    A a = new ImplA();
    B b = new ImplB();

    public void b() {
        b.b();
    }

    public void a() {
        a.a();          
    }       
}