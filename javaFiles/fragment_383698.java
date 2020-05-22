Map<String, BinaryOperation> ops = new HashMap<String, BinaryOperation>();
ops.put("ADD", new BinaryOperation() {
  public int apply(int a, int b) {
    return a + b;
  }
});
ops.put("MUL", new BinaryOperation() {
  public int apply(int a, int b) {
    return a * b;
  }
});
// etc.