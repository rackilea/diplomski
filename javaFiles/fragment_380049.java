public class ModelInstantiator extends StdValueInstantiator {

  private static final long serialVersionUID = -7760885448565898117L;

  private Class<? extends ModelObject> clazz;

  /**
   * @param config
   * @param valueType
   */
  public ModelInstantiator(DeserializationConfig config, Class<? extends ModelObject> clazz) {
    super(config, config.constructType(clazz));

    this.clazz = clazz;
  }

  @Override
  public boolean canCreateFromObjectWith() {
    return true;
  }

  @Override
  public Object createFromObjectWith(DeserializationContext ctxt, Object[] args) throws IOException, JsonProcessingException {
    UUID id = (UUID) args[0];

    // get local object
    ModelObject object = ...

    // if id was not found => create and add
    if (object == null) {
      try {
        object = clazz.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        throw new IOException(e);
      }

      object.setId(id);
      // add to local list
      ...
    }

    return object;
  }

  @Override
  public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig config) {
    CreatorProperty idProp = new CreatorProperty(new PropertyName("id"), config.constructType(UUID.class), null, null, null, null,
        0, null, PropertyMetadata.STD_REQUIRED);

    return new SettableBeanProperty[] { idProp };
  }

}