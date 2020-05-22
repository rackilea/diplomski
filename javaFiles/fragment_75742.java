import org.brianmckenna.wartremover.{WartTraverser, WartUniverse}

object JavaDate extends WartTraverser {
  def apply(u: WartUniverse): u.Traverser = {
    import u.universe._

    val JavaDate: Type = typeOf[java.util.Date]
    val JavaCal: Type = typeOf[java.util.Calendar]
    new Traverser {
      override def traverse(tree: Tree) {
        tree.tpe match {
          case JavaDate =>
            u.error(tree.pos, "java.util.Date not allowed")
          case JavaCal =>
            u.error(tree.pos, "java.util.Calendar not allowed")
          case _ =>
        }
        super.traverse(tree)
      }
    }
  }
}