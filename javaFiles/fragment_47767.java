public LogStore(Class<? extends List> clazz) {
    assertListTypeArgsValid(clazz);
    // ... the rest of the above method implementation ...
}
private void assertListOk(Class<? extends List> clazz) {
    boolean verified = false;
    for (Type intr : clazz.getGenericInterfaces()) {
        if (!(intr instanceof ParameterizedType)) continue;

        ParameterizedType pIntr = (ParameterizedType)intr;
        if (pIntr.getRawType().getTypeName() != "java.util.List") continue;

        Type[] typeArgs = pIntr.getActualTypeArguments();
        if (typeArgs.length != 1) break;

        Class<?> tac = (Class<?>)typeArgs[0];
        verified = tac.isAssignableFrom(LoggingEvent.class);
        if (!verified) throw new IllegalArgumentException("clazz must be a List<LoggingEvent>, and is a: "
                + pIntr.getTypeName());
        break;
    }
    if (!verified) throw new IllegalArgumentException("clazz must be a List<LoggingEvent>");
}