public void setPrevious(Bus bus) {
  this.previous = bus;
  if ( bus.next != this ){
    bus.next = this;
  }
}