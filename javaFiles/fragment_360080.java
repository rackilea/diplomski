public static void swap(MethodVisitor mv, Type stackTop, Type belowTop) {
    if (stackTop.getNumberSlots() == 1) {
        if (belowTop.getNumberSlots() == 1) {
            // Top = 1, below = 1
            mv.visitInsn(Opcodes.SWAP);
        } else {
            // Top = 1, below = 2
            mv.visitInsn(Opcodes.DUP_X2);
            mv.visitInsn(Opcodes.POP);
        }
    } else {
        if (belowTop.getNumberSlots() == 1) {
            // Top = 2, below = 1
            mv.visitInsn(Opcodes.DUP2_X1);
        } else {
            // Top = 2, below = 2
            mv.visitInsn(Opcodes.DUP2_X2);
        }
        mv.visitInsn(Opcodes.POP2);
    }
}