public class MyClass {
  int a;
}

public void a() {
  MyClass x = new MyClass(); // "x" is an object
  x.a = 1;
  b(x); // <- it calls method "b" with a reference/pointer to "MyClass x"
  System.out.println(x.a); // <- prints 2
}

public void b(MyClass x) {
  x.a = 2;
}