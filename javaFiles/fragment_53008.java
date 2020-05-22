Map<String,Object> result = /*result of parsing JSON input*/;

@SuppressWarnings({ "rawtypes", "unchecked" })
Map<String, List<String>> errors = (Map) result.get("errors");                                                       
for (Entry<String, List<String>> error : errors.entrySet()) {
    String name = error.getKey();
    List<String> messages = entry.getValue();

    Log.p(name);
    for (String message : messages)
        Log.p("  " + message);
}