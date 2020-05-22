protected void configure() {
    install(new PrivateModule() {
        @Override
        protected void configure() {
            // #bind makes bindings internal to this module unlike using AbstractModule
            // this binding only applies to bindings inside this module
            bind(Foo.class).toInstance(new Foo("first"));
            // Bar's foo dependency will use the preceding binding
            bind(Bar.class).annotatedWith(Names.named("first")).to(BarImpl.class);
            // if we'd stop here, this would be useless
            // but the key method here is #expose
            // it makes a binding visible outside as if we did AbstractModule#bind
            // but the binding that is exposed can use "private" bindings
            // in addition to the inherited bindings              
            expose(Bar.class).annotatedWith(Names.named("first"));
        }
    });
    install(new PrivateModule() {
        @Override
        protected void configure() {
            bind(Foo.class).toInstance(new Foo("second"));
            bind(Bar.class).annotatedWith(Names.named("second")).to(BarImpl.class);
            expose(Bar.class).annotatedWith(Names.named("second"));
        }
    });
         bind(MyApplication.class).asEagerSingleton();
    }
}