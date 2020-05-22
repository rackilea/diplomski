private static <T, U> U convertBy(T arg, Function... functions) {
  Object result = arg;
  for (Function f : functions) {
    result = f.apply(result);
  }
  return (U) result;
}

@Test
public void test() {
  Function<String, Integer> f1 = s -> s.length();
  Function<Integer, Double> f2 = i -> i*2.0;
  Double d = convertBy("test", f1, f2);
  assertThat(d).isEqualTo(8.0);
}