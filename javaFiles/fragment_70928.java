static <T> T waitForValue(Supplier<T> getMethod, BiPredicate<T, T> validator, T expected, int attempts) {
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
    return waitForValue(ThisClass::getString, ThisClass::validateString, expected, attempts);
}

private static int waitForInt(int expected, int attempts) {
    return waitForValue(ThisClass::getInt, ThisClass::validateInt, expected, attempts);
}