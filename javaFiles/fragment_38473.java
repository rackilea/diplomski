@Provider
public class GensonCustomResolver implements ContextResolver<Genson> {
  // configure the Genson instance
  private final Genson genson = new Genson.Builder().setWithClassMetadata(true).create();

  @Override
  public Genson getContext(Class<?> type) {
      return genson;
  }
}