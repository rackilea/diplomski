MyClass argument =
    arg.getAllValues()
        .stream()                            // Stream<SomeOtherClass>
        .filter(v -> v instanceof MyClass)   // Stream<SomeOtherClass>
        .map(MyClass.class::cast)            // Stream<MyClass>
        .findFirst()                         // Optional<MyClass>
        .orElse(null);                       // MyClass