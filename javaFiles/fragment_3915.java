public class C {
  private B b;
  ...
}
// addint a B class which contains the reference
public class B {
  private A b;
  @XmlIDREF
  @XmlElement
  public A getB() {
    return b;
  }
}