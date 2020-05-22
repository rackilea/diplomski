@Inject
private Instance<Foo> foo;

public void doStuff() {
  foo.isAmbiguous(); //you can check if there are more beans eligible for injection here
  foo.isResolvable(); //yet another useful check you might want

  // there are multiple selects you can use - based on type, annotation or both
  //select based on annotation (parameter is annotation INSTANCE), with this you require a Foo type with @Default qualifier
  foo.select(Default.Literal.INSTANCE).get();

  //select based on requested type, here you are asking for a Foo bean which also has a type MyType (implements interface or extends class with that type for instance)
  foo.select(MyType.class).get(); 

  // combined - type and annotation
  foo.select(MyType.class, Default.Literal.INSTANCE).get();
}