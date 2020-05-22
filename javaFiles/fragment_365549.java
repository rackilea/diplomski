public static <T extends Enum<T>, ID> void testUniqueIds(T[] enumValues, Function<T, ID> idExtractor) {
    String msg = "";

    Map<ID, T> enumsById = new HashMap<>();
    for (T enumValue : enumValues) {
      ID id = idExtractor.apply(enumValue);
      if (enumsById.containsKey(id)) {
        msg += "\nDuplicate ID found: '" + id.toString() + "' for enum: " + enumsById.get(id) + ", " + enumValue.name();
      } else {
        enumsById.put(id, enumValue);
      }
    }

    if (!msg.isEmpty()) {
      fail(msg);
    }
  }