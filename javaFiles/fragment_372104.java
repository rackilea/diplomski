public class SomeClass {
    private Map<Integer, String> map = new HashMap<>();

    // ...stuff this class does

    public String put(int key, String value) {
        if (map.containsKey(key))
            return null;
        return map.put(key, value);
    }

    // ...more stuff this class does
 }