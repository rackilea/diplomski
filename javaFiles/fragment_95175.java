public <C extends PropertyType>void functionLoop(
                         List<C> list, Function<C, String> t) {
  for (C p : list) {
    t.call(p);
  }
}