public static void main(String[] args) {
  Optional<String> s = Optional.of("input");
  System.out.println(s.map(Test::getOutput));
  System.out.println(s.flatMap(Test::getOutputOpt));
}

static String getOutput(String input) {
  return input == null ? null : "output for " + input;
}

static Optional<String> getOutputOpt(String input) {
  return input == null ? Optional.empty() : Optional.of("output for " + input);
}