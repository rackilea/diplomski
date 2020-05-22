public class ConvertToInvokeDynamic extends MethodVisitor {
    public static byte[] convertInvokeVirtual(
        InputStream in, String linkerClass, String linkerMethod) throws IOException {
        ClassReader cr = new ClassReader(in);
        ClassWriter cw = new ClassWriter(cr, 0);
        cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc,
                                             String signature, String[] exceptions) {
                return new ConvertToInvokeDynamic(
                    super.visitMethod(access, name, desc, signature, exceptions),
                    linkerClass, linkerMethod);
            }
        }, 0);
        return cw.toByteArray();
    }
    private final Handle bsm;

    public ConvertToInvokeDynamic(
        MethodVisitor target, String linkerClass, String linkerMethod) {
        super(Opcodes.ASM5, target);
        bsm = new Handle(Opcodes.H_INVOKESTATIC, linkerClass, linkerMethod,
          "(Ljava/lang/invoke/MethodHandles$Lookup;"
         + "Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;");
    }

    @Override
    public void visitMethodInsn(
        int opcode, String owner, String name, String desc, boolean itf) {
        if(opcode == Opcodes.INVOKEVIRTUAL) {
            desc = '('+(owner.charAt(0)!='['? 'L'+owner+';': owner)+desc.substring(1);
            super.visitInvokeDynamicInsn(name, desc, bsm);
        }
        else super.visitMethodInsn(opcode, owner, name, desc, itf);
    }
}