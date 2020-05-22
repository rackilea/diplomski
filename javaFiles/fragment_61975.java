Module module = ... // contains binding for X to A
if (useB) {
  module = Chaining.wrap(X.class).from(module).with(B.class);
}
if (useC) {
  module = Chaining.wrap(X.class).from(module).with(C.class);
}
if (useD) {
  module = Chaining.wrap(X.class).from(module).with(D.class);
}
if (useE) {
  module = Chaining.wrap(X.class).from(module).with(E.class);
}

Injector injector = Guice.createInjector(module);
X x = injector.createInstance(X.class);