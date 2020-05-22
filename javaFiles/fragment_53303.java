class A<B> {
  private final Class<B> clazz;

  A(Class<B> clazz) {
    this.clazz = clazz;
  }

  String getName() {
   return clazz.getSimpleName();
  }
}

A<Solution> var = new A<>(Solution.class);