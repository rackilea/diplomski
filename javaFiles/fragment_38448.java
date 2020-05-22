public final void push(final int value) {
    if(value >= -1 && value <= 5) {
        super.visitInsn(Opcodes.ICONST_0 + value);
    } else if(value == (byte)value) {
        super.visitIntInsn(Opcodes.BIPUSH, value);
    } else if(value == (short)value) {
        super.visitIntInsn(Opcodes.SIPUSH, value);
    } else {
        super.visitLdcInsn(value);
    }
}