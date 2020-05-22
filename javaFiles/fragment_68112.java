// bunch of stuff
Map<String, Object> map = ...;

// store some data
map.put("abc", 123L);
map.put("def", 456D);

// wait awhile
awhile();

// some time later, consume the data
// being particular about types
consumeLong((Long) map.remove("abc"));
consumeDouble((Double) map.remove("def"));