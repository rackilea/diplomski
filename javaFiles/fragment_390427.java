class MyAdvice {
  @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
  public static Object returnCachedValue(@Advice.Argument(0) String query) {
    if (cache.containsKey(query)) {
      return cache.get(query);
    } else {
      return null;
    }
  }

  @Advice.OnMethodExit
  public static Object processCachedValue(
          @Advice.Return(readOnly = false, typing = DYNAMIC) Object returned,
          @Advice.Enter Object enter) {
    if (enter != null) {
      returned = enter;
    } else {
      cache.put(query, returned);
    }
  }
}