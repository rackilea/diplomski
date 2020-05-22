import java.util.HashMap;
import java.util.Map;

class DontDoThis {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Map<String, String> genericMap = new HashMap<>();
    Map rawMap = genericMap;
    rawMap.put(new Object(), new Object());
    useMap(genericMap);
  }

  private static void useMap(Map<String, String> map) {
    for (String key : map.keySet()) {} // ClassCastException.
  }
}