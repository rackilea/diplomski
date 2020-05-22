public final class MyImmutableClass {
  // p is final, so it can't be re-referenced
  private final Person p;

  public MyImmutableClass(Person p) {
    this.p = p;
  }
  // it can be altered, though
  public void setPersonName(String name) {
    this.p.setName(name);
  }
  public String toString() {
    return "Person: " + p.getName();
  }
}