Map<FooKey, Foo> map = new ArrayList<FooKey, Foo>();
// Store
Foo fooObj = new Foo(new FooKey(123));
map.put(fooObj.id, fooObj);
// Retrieve
map.get(fooObj.id); // => fooObj
map.get(new FooKey(123)); // also fooObj if FooKey.equals is properly overridden