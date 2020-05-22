class Op implements Runnable {
  final int operand1, operand2;
  final char oprator;

  int result;

  Op(int operand1, char oprator, int operand2) {
    // Initialize fields.
  }

  @Override public void run() {
    result = /* code to calculate `operand1 (oprator) operand2` */;
  }
}