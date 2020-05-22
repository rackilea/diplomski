// i.e. class MyCodeTransformer extends GeneratorAdapter
@Override
public void visitFieldInsn(int opcode, String owner, String name, String desc) {
  if(opcode==Opcodes.PUTFIELD) {
    final Type fieldType = Type.getType(desc);
    super.swap(Type.getObjectType(owner), fieldType);
    if(fieldType.getSize()==1) super.dupX1(); else super.dupX2();
    super.visitLdcInsn(name);
    super.visitMethodInsn(Opcodes.INVOKESTATIC, "mypackage/MyDebugger",
        "fieldWrite", "(Ljava/lang/Object;Ljava/lang/String;)V", false);
  }
  super.visitFieldInsn(opcode, owner, name, desc);
}