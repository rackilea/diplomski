public class Ticket<T extends MySuperClass> {
  private T thing;
  public Ticket(T thing) {
    this.thing = thing;
  }
  public void update() {
    thing.update();
  }
  /* ... */
}