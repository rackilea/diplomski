abstract class Animal {
  public final void walk() {
    // do stuff
    moreWalking();
  }

  protected abstract void moreWalking();
}
class Person extends Animal {
  protected void moreWalking() {
    // do stuff
  }
}