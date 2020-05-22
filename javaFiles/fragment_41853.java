import xml._
import transform._

class AddPath(l: List[String]) extends RewriteRule {
  def listToNodes(l: List[String]): Seq[Node] = l match {
    case Nil => Seq.empty
    case first :: rest => 
      <node>{listToNodes(rest)}</node> % Attribute("name", Text(first), Null)
    //case first :: rest => 
      //<node>{listToNodes(rest)}</node> copy (label =  first)
  }

  def transformChild(child: Seq[Node]) = l match {
    case Nil => child
    case first :: rest =>
      child flatMap {
        case elem: Elem if elem.attribute("name") exists (_ contains Text(first)) =>
        //case elem: Elem if elem.label == first =>
          new AddPath(rest) transform elem
        case other => Seq(other)
      }
  }

  def appendToOrTransformChild(child: Seq[Node]) = {
    val newChild = transformChild(child)
    if (newChild == child)
      child ++ listToNodes(l)
    else
      newChild
  }

  override
  def transform(n: Node): Seq[Node] = n match {
    case elem: Elem => elem.copy(child = appendToOrTransformChild(elem.child))
    case other => other
  }
}