Map<String, Runnable> map = ...;

// store operations as well as data
// while we know what the types are
map.put("abc", () -> consumeLong(123L));
map.put("def", () -> consumeDouble(456D));

awhile();

// consume, but no longer particular about types
map.remove("abc").run();
map.remove("def").run();