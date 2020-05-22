class Kitchen {
  Kitchen k; // Here the kitchen is null
  int c;
  boolean empty;
  Cook chef;
  Kitchen() {
    this.c = 0;
    this.empty = true;
    chef = new Cook(k); // here you give a null object to the cook constructor

  }