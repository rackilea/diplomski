import java.io.FileReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(String.class, new StringDeserializer());
    Gson gson = gsonBuilder.create();
    Thing[] things = gson.fromJson(new FileReader("input.json"), Thing[].class);
    System.out.println(gson.toJson(things));
  }
}

class Thing
{
  String text;
}

class StringDeserializer implements JsonDeserializer<String>
{
  @Override
  public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException
  {
    if (json.isJsonPrimitive()) return json.getAsString();
    return "";
  }
}