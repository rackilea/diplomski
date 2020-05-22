public void writeItemArrayList(){
    try{
        File file = new File(this.getFilesDir(), "shoppinglist.json");
        /*change here*/Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Item.class, new InterfaceAdapter<Item>())
                .create();
        FileWriter writer = new FileWriter(file);
        writer.write(gson.toJson(items));
        writer.flush();
        writer.close();
    }catch (Exception e){

    }

}

public void readItemArrayList(){
    try{
        FileReader reader = new FileReader(new File(this.getFilesDir(), "shoppinglist.json"));
        Gson gson = new GsonBuilder().registerTypeAdapter(Item.class, new InterfaceAdapter<Item>())
                .create();
        this.items = gson.fromJson(reader, new TypeToken<ArrayList<Item>>(){}.getType());
        reader.close();
    } catch(Exception e){
        e.printStackTrace();
    }
}

class InterfaceAdapter<Item> implements JsonSerializer<Item>, JsonDeserializer<Item> {
    public JsonElement serialize(Item object, Type interfaceType, JsonSerializationContext context) {
        final JsonObject wrapper = new JsonObject();
        System.out.println("serialize " + object);
        wrapper.addProperty("type", object.getClass().getName());
        /*change here*/Gson gson = new Gson();
        /*change here*/wrapper.add("data", gson.toJsonTree(object, interfaceType));
        return wrapper;
    }
    ....... same code as before below .......
}