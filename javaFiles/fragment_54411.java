Iterable<String> upperStrings = Iterables.transform(myValueList, new Function<String,String>() {
  public String apply(String input) {
    // any transformation possible here.
    return (input == null) ? null : input.toUpperCase();
  }
});
Str str = Joiner.on(',').skipNulls().join(upperStrings);