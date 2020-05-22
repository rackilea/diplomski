public interface Interface<T> {
  public Result query(T query);
}

public class Subclass implements Interface<String> {
  ...
  public Result query(String queryStr) { 
    ...
  }
}