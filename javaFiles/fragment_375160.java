public <T> List<T> listEntity(String jsonCommand, Class<T> clazz) {

    List<T> lst =  new ArrayList<T>();
    try {
        // Consuming remote method
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(jsonCommand).getAsJsonArray();

        for(final JsonElement json: array){
            Gson g = new Gson();
            T entity = g.fromJson(json, clazz);
            lst.add(entity);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } return lst;
}