import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Type mapStringObjectType = new TypeToken<Map<String, Object>>() {}.getType();

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(mapStringObjectType, new RandomMapKeysAdapter());
    Gson gson = gsonBuilder.create();

    Map<String, Object> map = gson.fromJson(new FileReader("input.json"), mapStringObjectType);
    System.out.println(map);
  }
}

class RandomMapKeysAdapter implements JsonDeserializer<Map<String, Object>>
{
  @Override
  public Map<String, Object> deserialize(JsonElement json, Type unused, JsonDeserializationContext context)
      throws JsonParseException
  {
    // if not handling primitives, nulls and arrays, then just 
    if (!json.isJsonObject()) throw new JsonParseException("some meaningful message");

    Map<String, Object> result = new HashMap<String, Object> ();
    JsonObject jsonObject = json.getAsJsonObject();
    for (Entry<String, JsonElement> entry : jsonObject.entrySet())
    {
      String key = entry.getKey();
      JsonElement element = entry.getValue();
      if (element.isJsonPrimitive())
      {
        result.put(key, element.getAsString());
      }
      else if (element.isJsonObject())
      {
        result.put(key, context.deserialize(element, unused));
      }
      // if not handling nulls and arrays
      else
      {
        throw new JsonParseException("some meaningful message");
      }
    }
    return result;
  }
}