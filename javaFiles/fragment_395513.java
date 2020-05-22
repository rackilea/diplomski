static class TestSynchronized {
  private int i = 0;
  private int j = 0;

  void write() {
    synchronized(this) {
      i = 5;
      j = 7;
    }
  }

  void read_OK() {
    synchronized(this) {
      //assuming write was called beforehand
      print(i); //must be 5
      print(j); //must be 7
      print(i); //must be 5
    }
  }

  void read_NOT_OK() {
    synchronized(new Object()) { //not the same monitor
      //assuming write was called beforehand
      print(i); //can be 0 or 5
      print(j); //can be 0 or 7
    }        
  }

  void increment() {
    synchronized(this) {
      i = i + 1; //atomicity guarantees that if two threads call the method
                 //concurrently, i will be incremented twice
    }
  }
}