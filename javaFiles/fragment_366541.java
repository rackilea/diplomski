ImmutableListMultimap.Builder<String, SomeClass> builder = ImmutableListMultimap.builder();
for (final SomeClass elem : elements) {
    final String key = elem.getKey();
    builder.put(key, elem);
}
ImmutableListMultimap<String, SomeClass> multimap = builder.build();