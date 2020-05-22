class MyMethodVisitor extends MethodVisitor {
    private int used, usedAfterInjection;

    public MyMethodVisitor(int acc, String signature) {
        super(Opcodes.ASM5);
        used = Type.getArgumentsAndReturnSizes(signature)>>2;
        if((acc&Opcodes.ACC_STATIC)!=0) used--; // no this
    }

    @Override
    public void visitFrame(
            int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        if(type != Opcodes.F_NEW)
            throw new IllegalStateException("only expanded frames supported");
        int l = nLocal;
        for(int ix = 0; ix < nLocal; ix++)
            if(local[ix]==Opcodes.LONG || local[ix]==Opcodes.DOUBLE) l++;
        if(l > used) used = l;
        super.visitFrame(type, nLocal, local, nStack, stack);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        int newMax = var+(opcode==Opcodes.LSTORE || opcode==Opcodes.DSTORE? 2: 1);
        if(newMax > used) used = newMax;
        super.visitVarInsn(opcode, var);
    }

    @Override
    public void visitMethodInsn(
            int opcode, String owner, String name, String desc, boolean itf) {
        if(!shouldReplace(owner, name, desc)) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }
        else {
            int numVars = (Type.getArgumentsAndReturnSizes(desc)>>2)-1;
            usedAfterInjection = used+numVars;
            /*
              use local vars between [used, usedAfterInjection]
            */
        }
    }
    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, Math.max(used, usedAfterInjection));
    }
}