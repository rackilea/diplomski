interface Foo {
     int getTheVariable();
}

abstract class A implements Foo {
    abstract int getTheVariable();
    int doSomeWork() {
        return 5 * getTheVariable();
        }
    }

class B extends A implements Foo {
    int getTheVariable() { return 3; }
    }

class C extends A implements Foo {
    int getTheVariable() { return 2; }
    }