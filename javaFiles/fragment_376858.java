final class C {
  final boolean canChange;
  private int x;
  C(boolean canChange) { this.canChange = canChange; }
  public void setX(int newX) {
    if (canChange) {
      this.x = newX;
    } else {
      throw new IllegalStateException();
    }
  }
}