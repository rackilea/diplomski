public class HeterogeneousMapStructure {
    private final List<MapKey<?>> keyList;

    public HeterogeneousMap parseMap(JsonReader jsonReader) {
        HeterogeneousMap heterogeneousMap = new HeterogeneousMap();

        // ... find matching key
        MapKey<?> matchingMapKey = ...;
        /*
         * Compiling error:
         * The method put(TestClass.MapKey<T>, T) in the type TestClass.HeterogeneousMap 
         * is not applicable for the arguments (TestClass.MapKey<capture#1-of ?>, capture#2-of ?)
         */
        parseAndPut(heterogeneousMap, matchingMapKey, jsonReader);

        return heterogeneousMap;
    }

    private static <T> void parseAndPut(HeterogeneousMap map, MapKey<T> key, JsonReader in) throws IOException {
        map.put(key, key.parseValue(in));
    }
}