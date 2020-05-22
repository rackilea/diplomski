class ResultSetHandler<T> {
  ResultSetHandler<T>(Class<T> clazz) {
    this.clazz = clazz;
  }

  public T handle(ResultSet rs) throws SQLException {
    T object = null;
    if (rs.next()) {
      object = clazz.getConstructor(ResultSet.class).newInstance(rs)
    }
    return object;
  }
}