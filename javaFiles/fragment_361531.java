ArrayList<ArrayMap<String, String>> myArray = new ArrayList<>(8000);
for (int i = 0; i < 8000; i++) {
    ArrayMap<String, String> am = new ArrayMap<>(2);
    am.put("key1", string1);
    am.put("key2", string2);
    myArray.add(am);
}