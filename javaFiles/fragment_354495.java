Gson gson = new GsonBuilder().serializeNulls()
           .registerTypeAdapterFactory(
             new CollectionTypeAdapterFactory(new ConstructorConstructor(new HashMap<>()))
             )
           .create();

Result<List<Province>> result = gson.fromJson(jsonStr, new TypeToken<Result<List<Province>>>() {}.getType());