private interface Getter<T> {
    T get();
}

private interface Validator<T> {
    boolean test(T actual, T expected);
}

static <T> T waitForValue(Getter<T> getMethod, Validator<T> validator, T expected, int attempts) {
   T actual = null;
   for (int i = 0; i < attempts; i++){
      actual = getMethod.get();
      if (validator.test(actual, expected)) {
         return actual;
      }
   }
   return null;
}

private static String waitForString(String expected, int attempts) {
    Getter<String> getter = new Getter<String>() {
        @Override
        public String get() {
            return getString();
        }
    };
    Validator<String> validator = new Validator<String>() {
        @Override
        public boolean test(String actual, String expected) {
            return validateString(actual, expected);
        }
    };
    return waitForValue(getter, validator, expected, attempts);
}

private static int waitForInt(int expected, int attempts) {
    Getter<Integer> getter = new Getter<Integer>() {
        @Override
        public Integer get() {
            return getInt();
        }
    };
    Validator<Integer> validator = new Validator<Integer>() {
        @Override
        public boolean test(Integer actual, Integer expected) {
            return validateInt(actual, expected);
        }
    };
    return waitForValue(getter, validator, expected, attempts);
}