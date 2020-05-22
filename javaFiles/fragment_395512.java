static class TestVolatile {
  private int i = 0;
  private volatile int v = 0;

  void write() {
    i = 5;
    v = 7;
  }

  void read() {
    //assuming write was called beforehand
    print(i); //could be 0 or 5
    print(v); //must be 7
    print(i); //must be 5
  }

  void increment() {
    i = i + 1; //if two threads call the method concurrently
               //i could be incremented by 1 only, not 2: no atomicity
  }
}