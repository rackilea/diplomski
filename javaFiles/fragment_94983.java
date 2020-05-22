public static int methodContainingMethod(
    IntBinaryOperator theFunction, int first, int second, int... rest) {

  int value = theFunction.applyAsInt(first, second);
  for(int next: rest) value=theFunction.applyAsInt(value, next);
  return value;
}