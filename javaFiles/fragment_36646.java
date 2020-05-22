final class ListPerSubType {
  private final Map<Class<? extends Parent>, List> listPerSubType = new LinkedHashMap<>();

  public <T extends Parent> List<T> get(Class<T> cl) {
    // TODO: throw IllegalArgument if cl is parameterized.
    if (!listPerSubType.containsKey(cl)) {
      listPerSubType.put(cl, new ArrayList<T>());
    }
    List list = listPerSubType.get(cl);
    // This is type-safe since no other code exposes the
    // lists via type not gained from a type token.
    @SuppressWarnings("unchecked")
    List<T> typedList = list;
    return list;
  } 
}