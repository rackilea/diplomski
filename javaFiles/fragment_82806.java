// Ctor of SaveActivity.
@Inject
public SaveActivity(@YourAnnotation ChildClass childClass) { ... }

// In your module:
bind(ChildClass.class).annotatedWith(YourAnnotation.class)
    .toProvider(ChildClassProvider2.class);