public static void main(String[] args) {
    GsonBuilder builder = new GsonBuilder();

    builder.registerTypeAdapterFactory(new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            // Return null here if you don't want to handle the type.
            // This example returns an adapter for every type.
            return new TimestampAdapter<>(type);
        }
    });

    Gson gson = builder.create();
    Foobar baz = new Foobar("baz", 1);
    String json = gson.toJson(baz);
    System.out.println(json);
    System.out.println(gson.fromJson(json, Foobar.class));
}