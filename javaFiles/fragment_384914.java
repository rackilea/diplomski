public abstract class GenericPaginator<T> {
  public GenericPaginator() {
    Class<T> typeToken = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    // use reflection to invoke the finders methods
  }
}
public class PicturesPaginator extends GenericPaginator<Picture> {}