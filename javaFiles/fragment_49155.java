public class MyClassVisitor extends ClassVisitor {

    public MyClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor visitor = super.visitMethod(
            access, name, desc, signature, exceptions);
        if(method matches criteria) {
            visitor = new MyMethodVisitorAdapter(visitor);
        }
        return visitor;
    }
}