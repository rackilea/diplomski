public class Pass1Visitor extends MethodNode {
  MethodVisitor nextVisitor;

  public Pass1Visitor(MethodVisitor nextVisitor) {
    this.nextVisitor= nextVisitor;
  }

  ...

  public void visitEnd() {
    //do stuff the call the second visitor
    thisMethodNode.accept( nextVisitor );
  }
}