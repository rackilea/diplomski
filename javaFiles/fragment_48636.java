class FieldMatcher implements ElementMatcher<MethodDescription> {
  @Override
  public boolean matches(MethodDescription target) {
    String fieldName;
    if (target.getName().startsWith("set") || target.getName().startsWith("get")) {
      fieldName = target.substring(3, 4).toLowerCase() + target.substring(4);
    } else if (target.getName().startsWith("is")) {
      fieldName = target.substring(2, 3).toLowerCase() + target.substring(3);
    } else {
      return false;
    }
    target.getDeclaringType()
      .getDeclaredFields()
      .filter(named)
      .getOnly()
      .getDeclaredAnnotations()
      .isAnnotationPresent(Sensitive.class);
  }
}