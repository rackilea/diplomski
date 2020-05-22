private static final Joiner COMMA_JOINER = Joiner.on(",");

ListMultimap<String, String> groupedByDiscountName = ArrayListMultimap.create();
for (DiscountOption option : p.getDiscountOptions()) {
  groupedByDiscountName.put(getDiscountName(option), getValue(option));
}

ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
for (Entry<String, Collection<String>> e : groupedByDiscountName.asMap().entrySet()) {
  builder.put(e.getKey(), COMMA_JOINER.join(e.getValues());
}
Map<String, String> discountOptions = builder.build();