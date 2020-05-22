ImmutableMultimap.Builder<String, String> builder = ImmutableMultimap.builder();
builder.put("FOO", "accessId 1");
builder.put("BAR", "accessId 1");
ImmutableMultimap<String, String> accessIds = builder.build();
ImmutableMultimap<String, String> byAccessIds = accessIds.inverse();

Collection<String> keys = byAccessIds.get("accessId 1"); // ["FOO", "BAR"]
String key = doSomething(keys); // "BAR" is chosen
String merchant = merchants.get(key); // "merchant 2"