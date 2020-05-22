JsonDeserializer<MyData> deserializer = new JsonDeserializer<MyData>() {  
    @Override
    public MyData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List myList = new ArrayList<Entry>()

        JSONArray arr = obj.getJSONArray("entries");

        for (int i = 0; i < arr.length(); i++) {
          Entry entry = new Entry(
                new Long(arr[0]),
                new Long(arr[1])
          );
          myList.add(entry)
        }



        return new MyData(myList);
    }
};