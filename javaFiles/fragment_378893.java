@NonNull
public static TreeMap<Long, Long>  getOffsets(Context context) throws CpuStateException {
    File file = getOffsetsFile(context);
    TreeMap map;

    try {
        String s = Files.toString(file, Charsets.UTF_8).trim();
        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<TreeMap<Long, Long>>(){}.getType();
        map = gson.fromJson(s, type);
    } catch (IOException e) {
        throw new CpuStateException("Failed to read offsets!");
    }

    if (map == null)
        throw new CpuStateException("Failed to read offsets!");

    // So, I don't trust Gson. On some devices the above code seems to be producing a
    // TreeMap<String, Double/Float>. So let's assume it's either a String or a boxed primitive.
    // Even if the assumption is wrong we're no worse off than we were before.
    // The String we'll parse, the primitive we'll cast. Brace yourselves for a horrible hack!
    // TODO find a proper fix.
    Iterator it = map.keySet().iterator();
    TreeMap<Long, Long> treeMap = new TreeMap<>();
    while (it.hasNext()) {
        Object key = it.next();
        Object value = map.get(key);
        Long lKey, lValue;

        if ((key instanceof Long)) {
            lKey = (Long) key;
        } else {
            Log.e(TAG, "Invalid key type in TreeMap: " + key.getClass());
            if (key instanceof Number) {
                lKey = ((Number) key).longValue();
            } else if (key instanceof String) {
                lKey = Double.valueOf((String) key).longValue();
            } else {
                throw new IllegalArgumentException("Invalid key in TreeMap: "  + key);
            }
        }

        if ((value instanceof Long)) {
            lValue = (Long) value;
        } else {
            Log.e(TAG, "Invalid value type in TreeMap: " + value.getClass());
            if (value instanceof Number) {
                lValue = ((Number) value).longValue();
            } else if (value instanceof String) {
                lValue = Double.valueOf((String) value).longValue();
            } else {
                throw new IllegalArgumentException("Invalid value in TreeMap: " + value);
            }
        }
        treeMap.put(lKey, lValue);
    }

    return treeMap;
}