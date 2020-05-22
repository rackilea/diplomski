public class Something {
  private static volatile SomeClass staticField = null;

  public Something() {
  }

  public static SomeClass getStaticField() {
    if(Something.staticField == null)
      Something.staticField = new SomeClass();;
    return Something.staticField;
  }
}