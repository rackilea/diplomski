import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class App
{
  public static void main(String[] args) throws Exception
  {
    List keys1 = getKeysFromJson("input_without_lists.json");
    System.out.println(keys1.size());
    System.out.println(keys1);

    List keys2 = getKeysFromJson("input_with_lists.json");
    System.out.println(keys2.size());
    System.out.println(keys2);
  }

  static List getKeysFromJson(String fileName) throws Exception
  {
    Object things = new Gson().fromJson(new FileReader(fileName), Object.class);
    List keys = new ArrayList();
    collectAllTheKeys(keys, things);
    return keys;
  }

  static void collectAllTheKeys(List keys, Object o)
  {
    Collection values = null;
    if (o instanceof Map)
    {
      Map map = (Map) o;
      keys.addAll(map.keySet()); // collect keys at current level in hierarchy
      values = map.values();
    }
    else if (o instanceof Collection)
      values = (Collection) o;
    else // nothing further to collect keys from
      return;

    for (Object value : values)
      collectAllTheKeys(keys, value);
  }
}