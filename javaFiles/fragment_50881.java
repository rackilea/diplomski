public static String varType(final Object objectVar) {
    try {
      return objectVar.getClass().getSimpleName().toUpperCase();
    }
    catch (Exception e) { return null; }
}