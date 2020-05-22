abstract class ResultSetHandler<T> {

  protected abstract T create(ResultSet rs);

  public T handle(ResultSet rs) throws SQLException {
    T object = null;
    if (rs.next()) {
      object = create(rs);
    }
    return object;
  }
}