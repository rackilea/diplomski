import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.util.*;

public class Test1 {

  public static void main(String[] args) throws JSONException {
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", new Date());
    map.put("key3", 1);
    map.put("key4", null);
    map.put("key5", Collections.singletonMap("key5-key1", "value"));
    map.put("key6", Arrays.asList(1, 2, 3, 4));
    map.put("key7", BigDecimal.TEN);
    map.put("key8", new String[]{"a", "b", "c"});
    map.put("key9", TestEnum.A);
    map.put("key10", new TestEnum[]{TestEnum.A, TestEnum.B, TestEnum.C});

    Object json = buildJsonObj(map);
    System.out.println(json);
  }

  private static Object buildJsonObj(Object source) throws JSONException {
    if (source == null) {
      return null;
    }
    if (isSimpleValueType(source.getClass())) {
      return source;
    }

    if (source instanceof Map) {
      Map<Object, Object> map = (Map<Object, Object>) source;
      JSONObject jsonObject = new JSONObject();
      for (Map.Entry<Object, Object> entry : map.entrySet()) {
        Object key = entry.getKey();
        if (!(key instanceof String)) {
          throw new IllegalArgumentException("key must be string.");
        }
        jsonObject.put((String) key, buildJsonObj(entry.getValue()));
      }
      return jsonObject;
    }
    if (source instanceof Iterable) {
      Iterable<Object> iterable = (Iterable<Object>) source;
      JSONArray jsonArray = new JSONArray();
      for (Object value : iterable) {
        jsonArray.put(buildJsonObj(value));
      }
      return jsonArray;
    }
    if (source.getClass().isArray()) {
      Object[] array = (Object[]) source;
      JSONArray jsonArray = new JSONArray();
      for (Object value : array) {
        jsonArray.put(buildJsonObj(value));
      }
      return jsonArray;
    }

    throw new IllegalArgumentException("Unsupported type: " + source + ".");
  }

  private static boolean isSimpleValueType(Class<?> clazz) {
    return (Enum.class.isAssignableFrom(clazz) ||
        CharSequence.class.isAssignableFrom(clazz) ||
        Number.class.isAssignableFrom(clazz) ||
        Date.class.isAssignableFrom(clazz) ||
        URI.class == clazz || URL.class == clazz ||
        Locale.class == clazz);
  }

  public enum TestEnum {
    A, B, C
  }
}