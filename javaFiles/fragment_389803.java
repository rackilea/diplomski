bind(SomeClass.class).toProvider(() -> new SomeClassImpl());

// Either of the following will work
@Inject
OtherClass1(Provider<SomeClass> someClassProvider) { ... }

@Inject
OtherClass2(SomeClass someClass) { ... }