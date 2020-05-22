import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class TestClass {
  public static void main(final String... args) throws Throwable{
    int methodModifiers = Class.forName("java.lang.String")
        .getDeclaredMethod("join", CharSequence.class, CharSequence[].class)
        .getModifiers();

    Field varargsField = Class.forName("java.lang.reflect.Modifier")
        .getDeclaredField("VARARGS");
    varargsField.setAccessible(true);

    int varargsF = varargsField.getInt(null);
    int staticF = Modifier.STATIC;
    int publicF = Modifier.PUBLIC;

    if (methodModifiers == publicF + staticF + varargsF) {
      System.out.println("Correct");
    } else {
      System.out.println("Wrong");
    }
  }
}