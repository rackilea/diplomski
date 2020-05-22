Method methodToFind = null;
try {
  methodToFind = YouClassName.class.getMethod("myMethodToFind", (Class<?>[]) null);
} catch (NoSuchMethodException | SecurityException e) {
  // Your exception handling goes here
}