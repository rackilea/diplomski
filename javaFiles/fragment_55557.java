public interface A {
  // can't touch this
}

public class B implements A {
  // can't touch this
}

public class C extends B {
  // you want to add your own method
  void someNewMethod();
}

// And you wish to do this:
A foo = new C();
foo.someNewMethod();