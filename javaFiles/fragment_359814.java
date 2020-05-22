import org.objectweb.asm.*;
import org.objectweb.asm.commons.GeneratorAdapter;

public class MyTransformer extends ClassVisitor {

  public static byte[] transform(byte[] b) {
    final ClassReader classReader = new ClassReader(b);
    final ClassWriter cw = new ClassWriter(classReader,
      ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
    classReader.accept(new MyTransformer(cw), ClassReader.EXPAND_FRAMES);
    return cw.toByteArray();
  }

  public MyTransformer(ClassVisitor cv) {
    super(Opcodes.ASM5, cv);
  }
  @Override
  public MethodVisitor visitMethod(int access, String name, String desc,
      String signature, String[] exceptions) {

    MethodVisitor v=super.visitMethod(access, name, desc, signature, exceptions);
    if(name.equals("main") && desc.equals("([Ljava/lang/String;)V"))
      v=new MainTransformer(v, access, name, desc, signature, exceptions);
    return v;
  }
  @Override
  public void visitEnd() {
    appendShowTwo();
    super.visitEnd();
  }
  private void appendShowTwo() {
    final MethodVisitor defVisitor = super.visitMethod(
      Opcodes.ACC_PUBLIC, "showTwo", "()V", null, null);
    defVisitor.visitCode();
    defVisitor.visitFieldInsn(Opcodes.GETSTATIC,
      "java/lang/System", "out", "Ljava/io/PrintStream;");
    defVisitor.visitLdcInsn("Show Two Method");
    defVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
      "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    defVisitor.visitInsn(Opcodes.RETURN);
    defVisitor.visitMaxs(0, 0);
    defVisitor.visitEnd();
  }
  class MainTransformer extends GeneratorAdapter
  {
    MainTransformer(MethodVisitor delegate, int access, String name, String desc,
        String signature, String[] exceptions) {
      super(Opcodes.ASM5, delegate, access, name, desc);
    }
    @Override
    public void visitInsn(int opcode) {
      if(opcode==Opcodes.RETURN) {
        // before return insert c.showTwo();
        super.visitVarInsn(Opcodes.ALOAD, 1); // variable c
        super.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
            "ClassName", "showTwo", "()V", false);
      }
      super.visitInsn(opcode);
    }
  }
}