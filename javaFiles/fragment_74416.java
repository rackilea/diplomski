// the actual name is generally illegal in normal java syntax
class internal_Runnable implements Runnable {
  final int x;
  internal_Runnable(int _x) { x = _x; }
  void run() {
    System.out.writeln(x);
  }
}

void foo() {
  final x = 42;
  return new internal_Runnable(x);
}