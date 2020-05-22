modelMapper.createTypeMap(Optional.class, Optional.class).setConverter(new OptionalConverter());

public class OptionalConverter implements ConditionalConverter<Optional, Optional> {

  public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
    if (Optional.class.isAssignableFrom(destinationType)) {
      return MatchResult.FULL;
    } else {
      return MatchResult.NONE;
    }
  }

  private Class<?> getElementType(MappingContext<Optional, Optional> context) {
    Mapping mapping = context.getMapping();
    if (mapping instanceof PropertyMapping) {
      PropertyInfo destInfo = ((PropertyMapping) mapping).getLastDestinationProperty();
      Class<?> elementType = TypeResolver.resolveArgument(destInfo.getGenericType(),
                                                          destInfo.getInitialType());
      return elementType == TypeResolver.Unknown.class ? Object.class : elementType;
    } else if (context.getGenericDestinationType() instanceof ParameterizedType) {
      return Types.rawTypeFor(((ParameterizedType) context.getGenericDestinationType()).getActualTypeArguments()[0]);
    }

    return Object.class;
  }

  public Optional<?> convert(MappingContext<Optional, Optional> context) {
    Class<?> optionalType = getElementType(context);
    Optional source = context.getSource();
    Object dest = null;
    if (source != null && source.isPresent()) {
      MappingContext<?, ?> optionalContext = context.create(source.get(), optionalType);
      dest = context.getMappingEngine().map(optionalContext);
    }

    return Optional.ofNullable(dest);
  }

}