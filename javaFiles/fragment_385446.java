interface I {
  A foo();
}
class A {}
class B extends A {}
class C implements I {
  public B foo() { return null; }
}