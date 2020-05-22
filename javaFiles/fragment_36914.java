import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingStrategy(new MyFieldNamingStrategy());
    Gson gson = gsonBuilder.create();
    Egg egg = gson.fromJson(new FileReader("input.json"), Egg.class);
    System.out.println(gson.toJson(egg));
  }
}

class Egg
{
  private String mKey1;
  private String mKey2;
  private Map<String, String> mKey3;
}

class MyFieldNamingStrategy implements FieldNamingStrategy
{
  //Translates the Java field name into its JSON element name representation.
  @Override
  public String translateName(Field field)
  {
    String name = field.getName();
    char newFirstChar = Character.toLowerCase(name.charAt(1));
    return newFirstChar + name.substring(2);
  }
}