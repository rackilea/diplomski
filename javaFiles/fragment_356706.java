public class Test {
    public static void main(String[] args) throws Exception {   
        List<String> output = new ArrayList<>();
        JsonObject jsonObject = new JsonParser().parse(new FileReader("myJson.json")).getAsJsonObject();
        for (Map.Entry<String, JsonElement> object : jsonObject.entrySet()) {
            if (object.getValue() instanceof JsonObject) {
                output.add(computeJson((JsonObject)object.getValue()));
            }
        }
        System.out.println(output);
    }

    private static String computeJson(JsonObject source) {
        JsonObject output = new JsonObject();
        for (Map.Entry<String, JsonElement> object : source.entrySet()) {
            if (object.getValue() instanceof JsonObject) {
                for(Map.Entry<String, JsonElement> entry : ((JsonObject)object.getValue()).entrySet()) {
                    addEntry(object.getKey(), output, entry);
                }
            } else {
                addEntry(object.getKey(), output, object);
            }
        }
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(output);
    }

    private static void addEntry(String key, JsonObject output, Map.Entry<String, JsonElement> object) {
        switch(object.getKey().toLowerCase()) {
            case "string":
                output.addProperty(key, object.getValue().getAsString());
                break;
            case "int":
                output.addProperty(key, object.getValue().getAsInt());
                break;
            case "long":
                output.addProperty(key, object.getValue().getAsLong());
                break;
            //add other primitive cases
            default:
                output.add(key, object.getValue());
        }
    }
}