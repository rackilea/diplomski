public UnaryOperation calculate(int x, String opString) {
  BinaryOperation op = ops.get(opString);
  if(op == null)
    throw new RuntimeException("Operation not found.");
  else
    return op.partial(x);
}