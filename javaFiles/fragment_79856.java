abstract class A<T extends A.B> {
    class B {
      // ...
    }

    abstract void func(T param) {
      //..
    }
}

class Asub<Asub.B> extends A {
    class B extends A.B {
      // ...
    }


    @Override
    void func(Asub.B param) {
      // ...
    }
}