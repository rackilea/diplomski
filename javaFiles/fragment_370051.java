class Kitchen {
  //Kitchen k; I don't think you will need it anymore, you can delete this line
  int c;
  boolean empty;
  Cook chef;
  Kitchen() {
    this.c = 0;
    this.empty = true;
    chef = new Cook(this); // give yourself to the Cook

  }