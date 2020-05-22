install(new PrivateModule() {
  bind(Authorizer.class).to(ImplA.class);
  expose(SomeClass.class);
});
install(new PrivateModule() {
  bind(Authorizer.class).to(ImplB.class);
  expose(SomeOtherClass.class);
});