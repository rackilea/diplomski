private static final Gson GSON = new GsonBuilder().enableComplexMapKeySerialization()
                                                  .setPrettyPrinting()
                                                  .create();

private static <T> Multimap<String, T> readAnyClassMMap(Path jsonFile, Type typeOfT) throws IOException {
    Map<String, Set<T>> map = GSON.fromJson(Files.newBufferedReader(jsonFile, Charset.defaultCharset()), typeOfT);
    Multimap<String, T> mmap = HashMultimap.create();
    for (String key : map.keySet()) {
        mmap.putAll(key, map.get(key));
    }
    return mmap;
}