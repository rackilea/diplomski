import lombok.experimental.ExtensionMethod;

@ExtensionMethod({java.util.Arrays.class, Extensions.class})
public class ExtensionMethodExample {
  public String test() {
    int[] intArray = {5, 3, 8, 2};
    intArray.sort();

    String iAmNull = null;
    return iAmNull.or("hELlO, WORlD!".toTitleCase());
  }
}

class Extensions {
  public static <T> T or(T obj, T ifNull) {
    return obj != null ? obj : ifNull;
  }

  public static String toTitleCase(String in) {
    if (in.isEmpty()) return in;
    return "" + Character.toTitleCase(in.charAt(0)) +
        in.substring(1).toLowerCase();
  }
}