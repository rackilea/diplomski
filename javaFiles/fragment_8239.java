class GenericDao implements Dao<T>
  @Inject
  GenericDao(TypeLiteral<T> type) {
    this.whatever = type;
  }
}