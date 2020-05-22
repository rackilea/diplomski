class C {
  static final int INITIALIZED = 0;
  static final int RUNNING = 1;
  static final int STOPPED = 2;
  void m(int i) {
    // the default method
  }
  void m(int@@INITIALIZED i) {
    // handle the case when we're in the initialized `state'
  }
  void m(int@@RUNNING i) {
    // handle the case when we're in the running `state'
  }
  void m(int@@STOPPED i) {
    // handle the case when we're in the stopped `state'
  }
}