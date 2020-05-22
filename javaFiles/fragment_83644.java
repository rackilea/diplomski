abstract class A {
    public abstract void method();
}

abstract class CD extends A {
    void method(){print "Bye";}
}

class B extends A {
    void method(){print "Hello";}
}

class C extends CD { }

class D extends CD { }