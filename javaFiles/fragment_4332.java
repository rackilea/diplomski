class InterfaceToHelperRewriter(mv: MethodVisitor) extends MethodVisitor(Opcodes.ASM5, mv) {
  override def visitMethodInsn(opcode: Int, owner: String, name: String, desc: String, itf: Boolean) = opcode match {
    case INVOKESPECIAL if owner.getInternalClass.isInterface =>
      println(s"Messing up $owner $name $desc")
      super.visitMethodInsn(INVOKESTATIC, owner + "helper", name, desc.addParam(owner), false)  // <-------- i used itf instead of false, now it generates a MethodRef and not a InterfaceMethodRef
    case _ =>
      super.visitMethodInsn(opcode, owner, name, desc, itf)
  }
}