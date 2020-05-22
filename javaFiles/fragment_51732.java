private <T extends Number & Comparable<T>> int compareNumbers(Number number1, Number number2) {
  @SuppressWarnings("unchecked")
  T number1Cast = (T) number1;
  @SuppressWarnings("unchecked")
  T number2Cast = (T) number2;
  return number1Cast.compareTo(number2Cast);
}