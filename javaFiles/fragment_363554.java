import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GsonFoo
{
  public static void main(String[] args) throws Exception
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(AttributeScope.class, new AttributeScopeDeserializer());
    Gson gson = gsonBuilder.create();

    TruncateElement element = gson.fromJson(new FileReader("input.json"), TruncateElement.class);

    System.out.println(element.lower);
    System.out.println(element.upper);
    System.out.println(element.delimiter);
    System.out.println(element.scope.get(0));
  }
}

class AttributeScopeDeserializer implements JsonDeserializer<AttributeScope>
{
  @Override
  public AttributeScope deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException
  {
    AttributeScope[] scopes = AttributeScope.values();
    for (AttributeScope scope : scopes)
    {
      if (scope.scope.equals(json.getAsString()))
        return scope;
    }
    return null;
  }
}

class TruncateElement
{
  int lower;
  int upper;
  String delimiter;
  List<AttributeScope> scope;
}

enum AttributeScope
{
  TITLE("${title}"), DESCRIPTION("${description}");

  String scope;

  AttributeScope(String scope)
  {
    this.scope = scope;
  }
}