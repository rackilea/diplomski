Gson gson = new Gson();
Collection<Integer> ints = Lists.immutableList(1,2,3,4,5);

//(Serialization)
String json = gson.toJson(ints); ==> json is [1,2,3,4,5]

//(Deserialization)
Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
Collection<Integer> ints2 = gson.fromJson(json, collectionType);
//ints2 is same as ints