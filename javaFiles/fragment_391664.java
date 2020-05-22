Map<String, Integer> map = new HashMap<>();
.........
public void putAndIncrement(String key, int value) {
    Integer prev = map.get(key);
    Integer newValue = value;
    if (prev != null) {
        newValue += prev.intValue();
    }
    map.put(newValue);
}