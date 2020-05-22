// Not safe: will throw an exception
for (Map.Entry<String, String> entry : map.entrySet()) {
    if (entry.getKey().equals("foo")) {
        map.put("bar", "Hello");
    }
}