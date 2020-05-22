Module baseModule = ... // contains binding for X to A

if (useB) {
  Module wrapperModule = new ChainingModule() {
    void configure() {
      wrap(X.class).from(baseModule).with(B.class); // possible to use .in(...) etc. here
      // In this case, this line is equivalent to

      // bind(X.class).annotatedWith(InInstance(B.class)).to(A.class);
      // bind(X.class).to(B.class);

      // It has the advantage of automatically looking up the current binding
      // for X in the base module, which makes it easy to chain this.
    }
  }
  baseModule = Modules.override(baseModule).with(wrapperModule);
}

...