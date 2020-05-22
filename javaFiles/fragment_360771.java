class A {
  protected int foo;
}

class B extends A {
  public B() {
    this.foo = 42;
  }
}

class C extends A {
  public C() {
    this.foo = 0xf00;
  }
}

class D extends B,C {
  public D() {
    System.out.println( "Foo is: "+foo ); //Now what?
  }
}