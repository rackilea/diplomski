for (First<?> first : firstUnknownList) {
  // OK at compile time; OK at runtime unless the method throws an exception.
  Object obj = first.producer();

  // OK at compile time; may fail at runtime if null is not an acceptable parameter.
  first.consumer(null);

  // Compiler error - you can't have a reference to a ?.
  first.consumer(/* some maybe non-null value */);
}