public static <I,O> void transfer(Collection<? extends I> input,
                                  Collection<? super O> output,
                                  Converter<? super I, ? extends O> converter) {
  for (I inobj : input) {
    O outobj = converter.convert(inobj);
    output.put(outobj);
  }
}