class A{
    // ...
    public static A ofWithB(){
      A a = new A();
      B b = new B();
      a.setB(b);
      b.setA(a);
      return a;     
    }
}

A a = A.ofWithB();
B b = a.getB();