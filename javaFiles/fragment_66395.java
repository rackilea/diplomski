void thing() {
  synchronized(foo) {
    stuff(); // this works fine!
  }
}
void stuff() {
  synchronized(foo) {
    doMoreStuff();
  }
}