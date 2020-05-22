ImmutableListMultimap<String, SomeClass> multimap = Multimaps.index(
    elements,
    new Function<SomeClass, String>() {
        @Override public String apply(final SomeClass element) {
            return element.getKey();
        }
    });