class Envelope {
  void x() {
    System.out.println("Hello");
  }
  class Enclosure {
    void x() {
      Envelope.this.x(); /* Qualified*/
    }
  }
}