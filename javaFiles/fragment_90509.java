public class MaxStackClassVisitor extends ClassVisitor {

    Map<String, Integer> frameMap = new HashMap<String, Integer> ();

    public MaxStackClassVisitor ( ClassVisitor v ) {
        super ( Opcodes.ASM4, v );
    }

    @Override
    public MethodVisitor visitMethod ( int access, String name, 
        String desc, String signature,
            String[] exceptions ) {
        return new MaxStackMethodVisitor ( 
            super.visitMethod ( access, name, desc, signature, exceptions ), 
            this, ( access + name + desc + signature ) );
    }
}

public class MaxStackMethodVisitor extends MethodVisitor {

    final MaxStackClassVisitor cv;
    final String name;

    public MaxStackMethodVisitor ( MethodVisitor mv, 
        MaxStackClassVisitor cv, String name ) {
        super ( Opcodes.ASM4, mv );
        this.cv = cv;
        this.name = name;
    }

    @Override
    public void visitMaxs ( int maxStack, int maxLocals ) {
        cv.frameMap.put ( name, ( maxStack + maxLocals ) * 4 );
        super.visitMaxs ( maxStack, maxLocals );
    }
}