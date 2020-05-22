import xxx.GenericClassBuilder
import xxx.GenericClass
import xxx.ClassA
import xxx.ClassB

def p(s: String): Option[GenericClass] = {
   val maybePb: Option[GenericClassBuilder] = s match {
      case "ClassA" => Some(ClassA.newBuilder())
      case "ClassB" => Some(ClassB.newBuilder())
      case _ => None
   }
   maybePb.foreach { pb => ... do side-effecty stuff with pb ...}
   maybePb.map(_.build())
}