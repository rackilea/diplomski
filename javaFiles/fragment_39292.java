abstract class Base {
  Base() {
    ctor();
    init();
  }
  abstract void ctor();
  abstract void init();
}