// With adapter
final Gson gson = new GsonBuilder().registerTypeAdapter(Pair.class,
        new PairAdapter()).create();

// With serializer
final Gson gson = new GsonBuilder().registerTypeAdapter(Pair.class,
        new PairSerializer()).create();