String[] keys = new String[2];
Integer[] values = new Integer[2];
Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
for (int i = 0; i < 2 && iterator.hasNext(); i++) {
    Map.Entry<String,Integer> entry = iterator.next();
    keys[i] = entry.getKey();
    values[i] = entry.getValue();
}