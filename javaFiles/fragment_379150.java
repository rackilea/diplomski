List<Future<String>> tasks = new ArrayList<>();
for (Map.Entry<String, NSObject> entry : dict.entrySet()) {
    key = entry.getKey();
    value = entry.getValue();
    tasks.add(executor.submit(new ParsePlistThread(key, value, url)));
}