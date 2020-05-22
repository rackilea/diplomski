class AStrore implements StackManipulation {

  private final int index; // Constructor omitted

  public boolean isValid() {
    return index >= 0;
  }

  public Size apply(MethodVisitor methodVisitor, Instrumentation.Context context) {
    methodVisitor.visitIntInsn(Opcodes.ASTORE, index);
    return new Size(-1, 0);
  }
}