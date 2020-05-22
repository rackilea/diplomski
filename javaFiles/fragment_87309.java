public class MiddlewareModule<MessageType> extends AbstractModule {
  private final Class<MessageType> _clazz;
  private final List<Class<? extends PostprocessorMiddleware<MessageType>>> _postprocessors;
  private final List<Class<? extends PreprocessorMiddleware<MessageType>>> _preprocessors;

  public MiddlewareModule(
    // Accept the message type in a way that survives erasure.
    Class<MessageType> clazz,
    List<Class<? extends PreprocessorMiddleware<MessageType>>> preprocessors,
    List<Class<? extends PostprocessorMiddleware<MessageType>>> postprocessors
  ) {
    _clazz = clazz;
    _preprocessors = preprocessors;
    _postprocessors = postprocessors;
  }

  @Override
  protected void configure() {
    // Use the Class to create your fully-specified TypeLiteral.
    bindAllMiddleware(_preprocessors,
        Types.newParameterizedType(PreprocessorMiddleware.class, _clazz));
    bindAllMiddleware(_postprocessors,
        Types.newParameterizedType(PostprocessorMiddleware.class, _clazz));
  }

  private <T extends Middleware> void bindAllMiddleware(List<Class<? extends T>> middleware, TypeLiteral<T> type) {
    Multibinder<T> multibinder = Multibinder.newSetBinder(binder(), type);

    middleware.forEach(middlewareType -> bindMiddleware(multibinder, middlewareType));
  }

  private <T extends Middleware> void bindMiddleware(Multibinder<T> binder, Class<? extends T> type) {
    bind(type).in(Singleton.class);  // Don't call binder() explicitly.
    binder.addBinding().to(type);
  }
}