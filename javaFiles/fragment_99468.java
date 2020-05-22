class QueryResolver implements GraphQLQueryResolver {

  public Connection<User> users(int first, String after, DataFetchingEnvironment env) {
    return new SimpleListConnection<>(Collections.singletonList(new User(1L, "Luke"))).get(env);
  }
}