public class MyNullConverter implements Converter {
  @Override
  public Object convert(final Class type, final Object value) {
    try {
      return value == null ? type.newInstance() : value;
    } catch (final InstantiationException e) {
      return null;
    } catch (final IllegalAccessException e) {
      return null;
    }
  }
}