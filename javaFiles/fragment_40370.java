public static class VisitorContextWithoutSchemaInlining extends VisitorContext {
  @Override
  public String addSeenSchemaUri(final JavaType aSeenSchema) {
    return getSeenSchemaUri(aSeenSchema);
  }

  @Override
  public String getSeenSchemaUri(final JavaType aSeenSchema) {
    return isEligibleForInlineSchema(aSeenSchema) ? javaTypeToUrn(aSeenSchema) : null;
  }

  private boolean isEligibleForInlineSchema(final JavaType type) {
    return type.getRawClass() != String.class
                && !isBoxedPrimitive(type)
                && !type.isPrimitive()
                && !type.isMapLikeType()
                && !type.isCollectionLikeType()
                && type.getRawClass() == DateTime.class
                ;
    }

    private boolean isBoxedPrimitive(final JavaType type) {
      return type.getRawClass() == Boolean.class
             || type.getRawClass() == Byte.class
             || type.getRawClass() == Long.class
             || type.getRawClass() == Integer.class
             || type.getRawClass() == Short.class
             || type.getRawClass() == Float.class
             || type.getRawClass() == Double.class
             ;
    }
}