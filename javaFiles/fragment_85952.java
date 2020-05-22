final Collection<String> filtered = FluentIterable
    .from(tokens)
    .transform(new Function<String, String>() {
       @Override
       public String apply(final String input) {
         return input == null ? "" : input.trim();
       }
     })
    .filter(new Predicate<String>() {
       @Override
       public boolean apply(final String input) {
         return !Strings.isNullOrEmpty(input);
       }
     })
   .toImmutableList();