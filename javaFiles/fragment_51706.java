Gson gson = new GsonBuilder()
            .registerTypeAdapter(BillItem.class, new BillItemDeserializer())
            .registerTypeAdapter(Bills.class, new BillsDeserializer())
            .create();

RestAdapter.Builder builder = new RestAdapter.Builder()
            //...
            .setConverter(new GsonConverter(gson));

public class BillsDeserializer implements JsonDeserializer<StringList> {

    public Bills deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
         BillItemList value = new BillItemList();
         if (json.isJsonArray()) {
             for (JsonElement element : json.getAsJsonArray()) {
                 value.add(gson.fromJson(element, BillItem.class));
             }
         } else {
             value.add(gson.fromJson(element, BillItem.class));
         }
         return value;
     }
}