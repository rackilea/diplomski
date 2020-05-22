for(int i = 0; i < foos.size();i++) {
  Foo.FooBuilder builder = Foo.builder();
  builder.a("bar1");

  if(listOfIds.contains(foo.getId())) {
  builder.b("bar2");
  //TODO: copy other values from `foos.get(i)` to builder. It's your turn
  //update modified to the list at i
  foos.set(i, builder.build());   
}