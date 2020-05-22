enum MessageType {
  WARN, INFO, ERROR;

  private static Map<pl.different.MessageType, MessageType> byPlDiffMType = 
      new EnumMap<>(Map.of(
          pl.different.MessageType.WARN, WARN,
          pl.different.MessageType.INFO, INFO,
          pl.different.MessageType.ERROR, ERROR
      ));

  private static Map<com.other.MessageType, MessageType> byCOthMType = 
      new EnumMap<>(Map.of(
          com.other.MessageType.WARNING, WARN,
          com.other.MessageType.INFO, INFO,
          com.other.MessageType.ERROR, ERROR
      ));

  public static MessageType of(pl.different.MessageType value) {
      return of(byPlDiffMType, value);
  }

  public static MessageType of(com.other.MessageType value) {
      return of(byCOthMType, value);
  }

  private static <V> MessageType of(Map<V, MessageType> map, V value) {
     final MessageType result = map.get(value);
     if (result == null) {
         throw new IllegalArgumentException();
     } else {
         return result;
     }
  }
}