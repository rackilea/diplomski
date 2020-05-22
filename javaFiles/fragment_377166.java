Foo.FooBuilder builder = Foo.builder();

for(Foo foo: foos) {
  builder.a("bar1");

  if(listOfIds.contains(foo.getId())) {
    builder.b("bar2");
  }

  foo = builder.build();

}