class MyRepository<T> 
  private final Class<T> clazz;
  MyRepository(Class<T> clazz) { this.clazz = clazz; }
  T load(int id) {
    final String tableName = clazz.getSimpleName() + "Table";
    /* connect, retrieve data, disconnect */
    final T t = clazz.newInstance(); // must be inside try/catch
    /* fill instance t with data from database somehow (using reflection probably, which, again, needs to know what clazz is */
    return t;
  }
}

...
final MyRepository<User> userRepository = new MyRepository<User>(User.class);
final User user = userRepository.load(123);
...