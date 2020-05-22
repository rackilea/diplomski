import java.lang.reflect.Field;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConvertor {

private static GsonBuilder gsonBuilder;
private static Gson gson;

private JsonConvertor() {

}
public static Object fromJson(String json, Class clz)
{
    gson=new Gson();
    return gson.fromJson(json,clz);
}

public static String toJson(Object obj) {
    gsonBuilder = new GsonBuilder();
    gsonBuilder = gsonBuilder
            .addSerializationExclusionStrategy(new CustomIclusionStrategy(
                    obj.getClass()));
    gson = gsonBuilder.create();
    String json = gson.toJson(obj);
    return json;
}