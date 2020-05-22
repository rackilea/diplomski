public class ClassDeserializerAdapter implements JsonDeserializer<BaseClass>
{
    private String typeName;
    private Gson gson;
    private Map<String, Class<? extends BaseClass>> classTypeRegistry;

    ClassDeserializerAdapter(String typeName)
    {
        this.typeName = typeName;
        gson = new Gson();
        classTypeRegistry = new HashMap<>();
    }

    void registerClassType(String classTypeName, Class<? extends BaseClass> classType)
    {
        // registering Types to Strings
        classTypeRegistry.put(classTypeName, classType);
    }

    @Override
    public BaseClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
        throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement typeElement = jsonObject.get(typeName);
        String method = typeElement.getAsString();
        Class<? extends BaseClass> classType = classTypeRegistry.get(method);
        BaseClass result = gson.fromJson(json, classType);
        return result;
    }
}