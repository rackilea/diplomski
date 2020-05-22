public class Overloaded {

  private static final String[] CONST_ARR = {"1", "2", "3"};

  public static void main(String[] args) {
    Overloaded o = new Overloaded();

    o.withConstantStrings();

    String[] a = {"1", "2"};

    o.withAdditionalStrings(a);
  }

  public void withConstantStrings() {
    libraryVarArgsCode(CONST_ARR);
  }

  public void withAdditionalStrings(String... additional) {
    String[] join = new String[additional.length + CONST_ARR.length];

    System.arraycopy(CONST_ARR, 0, join, 0, CONST_ARR.length);
    System.arraycopy(additional, 0, join, CONST_ARR.length, additional.length);

    libraryVarArgsCode(join);
  }

  public void libraryVarArgsCode(String... args) {
    // librabry code here
  }
}