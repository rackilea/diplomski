class Parent {
  private foo() {println "foo"}
}

class Child extends Parent {
  public bar() {super.foo()}
}

new Child().bar()