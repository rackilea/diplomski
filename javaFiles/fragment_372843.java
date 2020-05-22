@MapKey
@interface YourAnnotation {
  String foo();
}

@Provides @YourAnnotation(foo="bar") YourClass getYourClassForBar() { /* ... */ }

// Dagger will create a multibinding that would allow you to inject this:
@Inject Map<YourAnnotation, YourClass> map;