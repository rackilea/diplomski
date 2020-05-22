public enum Name {
  JOHN("John"), Mary("Mary"), TAB("\n")

  private int str;

  private Name(int str) {
    this.str = str;
  }

  public String toString() {
    return str;
  }
}