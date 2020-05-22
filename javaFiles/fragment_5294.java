public final static class FieldEnumWrapper<E extends Enum<E> & Field> {
  private final Class<E> clazz;
  private final ImmutableMap<String, E> index;

  public static <E extends Enum<E> & Field> 
      FieldEnumWrapper<E> of(final Class<E> clazz) {
    return new FieldEnumWrapper<E>(clazz);
  }

  private FieldEnumWrapper(final Class<E> clazz) {
    this.clazz = clazz;
    this.index = Maps.uniqueIndex(
        EnumSet.allOf(clazz), new Function<E, String>() {
          @Override
          public String apply(final E input) {
            return input.searchName();
          }
        });
  }

  public Class<E> clazz() {
    return clazz;
  }

  public Field valueOfSearchName(final String searchName) {
    return index.get(searchName);
  }
}