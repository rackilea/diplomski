Map<String, ArrayList<byte[]>> myMap = new HashMap<>();

public void setValue(String key, byte[] value) {
    ArrayList<byte[]> valueList = this.myMap.get(key);
    if (valueList == null) {
        valueList = new ArrayList<>();
        this.myMap.put(key, valueList);
    }
    valueList.add(value);
}