public class JsonSerializerFactory {
    private static final ThreadLocal<JsonSerializer> JSON_SERIALIZER = 
        new ThreadLocal<JsonSerializer>() {
            @Override 
            protected JsonSerializer initialValue() {
                 return new JsonSerializer();
            }
        };

    public static JsonSerializer get() {
        return JSON_SERIALIZER;
    }
}