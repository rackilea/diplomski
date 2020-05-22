import com.google.gson.Gson;
import com.google.gson.JsonParser;

private static Gson gson = new Gson();
private static final JsonParser parser = new JsonParser();

public static <T> T toPojoObject(String json, Class<T> clazz, Gson aGson) {
    return aGson.fromJson(createJSONObject(json).getAsJsonObject(), clazz);
}

public static JsonElement createJSONObject(String json) {
    return parser.parse(json);
}