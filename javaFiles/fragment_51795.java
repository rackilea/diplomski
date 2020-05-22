public class IntAndStringMap<V> {
    private Map<String, Integer> keyMap;

    private List<V> theList;

    public IntAndStringMap() {
        keyMap = new HashMap<String, Integer>();
        theList = new ArrayList<V>();
    }

    public void put(int intKey, String stringKey, V value) {
        keyMap.put(stringKey, intKey);
        theList.ensureCapacity(intKey + 1); // ensure no IndexOutOfBoundsException
        theList.set(intKey, value);
    }

    public V get(int intKey) {
        return theList.get(intKey);
    }

    public V get(String stringKey) {
        return theList.get(keyMap.get(stringKey));
    }
}