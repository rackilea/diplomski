public class CustomJsonArraySerializer<T> implements JsonSerializer<T[]> {
    @Override
    public JsonElement serialize(T[] source, Type type, JsonSerializationContext context) {
        JsonArray jsonArray = new JsonArray();
        for(T item : source){
            if(item != null) { // skip null values
                jsonArray.add(context.serialize(item));
            }
        }
        return jsonArray;
    }
}