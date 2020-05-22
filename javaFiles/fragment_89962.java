public void a() {
  int x = 1; // "x" is a primitive
  b(x); // <- it calls method "b" with a copy of "int x"
  System.out.println(x); // <- prints 1
}

public void b(int x) {
  x = 2;
}