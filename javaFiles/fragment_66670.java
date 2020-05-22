public class MDataSerializer implements JsonSerializer<MData> {

    @Override
    public JsonElement serialize(MData src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject obj = new JsonObject();
        obj.addProperty("version", src.version);
        obj.addProperty("ttl", src.ttl);

        for(Foo foo : src.foos) {
            obj.addProperty(foo.getKey(), foo.getValue());
        }

        return obj;
    }
}