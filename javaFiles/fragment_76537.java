public class Test2 {
    @SafeVarargs
    static <T> ArrayList<T> newArrayList(T... arg) {
        return new ArrayList<T>(Arrays.asList(arg));
    }
    private final List<Map<String, Object>> maps = newArrayList(
        createMap(null, Collections.EMPTY_MAP)
     );

    public static Map<String, Object> createMap(String id, Map<String,String> m) {
        return null;
    }
}