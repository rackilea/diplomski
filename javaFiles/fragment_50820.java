Foo foo = new Foo();
Map<Object, Object> bar = new HashMap<>();
foo.setBar(bar);
bar.put("foo", "bar");
assert foo.getBar() == bar : "getBar() and bar do not share the same memory location (aren't the same object)";
assert foo.getBar().get("foo").equals("bar") : "Calls to put(...) aren't persisted after setBar(...) call.";