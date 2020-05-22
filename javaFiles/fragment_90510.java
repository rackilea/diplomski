public class CallStackClassVisitor extends ClassVisitor {

    final Map<String, Integer> frameSizes;
    final String className;

    public CallStackClassVisitor ( ClassVisitor v, 
        Map<String, Integer> frameSizes, String className ) {
        super ( Opcodes.ASM4, v );
        this.frameSizes = frameSizes;
        this.className = className;
    }

    @Override
    public MethodVisitor visitMethod ( int access, String name, 
        String desc, String signature, String[] exceptions ) {
        MethodVisitor m = super.visitMethod ( access, name, desc, 
                             signature, exceptions );
        return new CallStackMethodVisitor ( m, 
                 frameSizes.get ( access + name + desc + signature ) );
    }
}

public class CallStackMethodVisitor extends MethodVisitor {

    final int size;

    public CallStackMethodVisitor ( MethodVisitor mv, int size ) {
        super ( Opcodes.ASM4, mv );
        this.size = size;
    }

    @Override
    public void visitCode () {
        visitIntInsn ( Opcodes.SIPUSH, size );
        visitMethodInsn ( Opcodes.INVOKESTATIC, "phil/agent/MaxStackLog",
                "enter", "(I)V" );
        super.visitCode ();
    }

    @Override
    public void visitInsn ( int inst ) {
        switch ( inst ) {
            case Opcodes.ARETURN:
            case Opcodes.DRETURN:
            case Opcodes.FRETURN:
            case Opcodes.IRETURN:
            case Opcodes.LRETURN:
            case Opcodes.RETURN:
            case Opcodes.ATHROW:
                visitIntInsn ( Opcodes.SIPUSH, size );
                visitMethodInsn ( Opcodes.INVOKESTATIC,
                        "phil/agent/MaxStackLog", "exit", "(I)V" );
                break;
            default:
                break;
        }

        super.visitInsn ( inst );
    }
}