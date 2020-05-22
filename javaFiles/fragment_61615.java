ImmutableSetMultimap<class1, String> dict2 = dict.entrySet().stream()
   .collect(ImmutableSetMultimap.flatteningToImmutableSetMultimap(
      entry -> entry.getKey(),
      entry -> entry.getValue().stream()))
   .inverse();
ImmutableMultiset<class1> dict1 = dict2.keys();