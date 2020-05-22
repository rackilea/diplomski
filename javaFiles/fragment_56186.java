case class MyAnnotation(name: String) extends annotation.ClassfileAnnotation

@MyAnnotation(name = "asd")
class MyClass

object MyApp extends App {
  import reflect.runtime.universe._
  import scala.reflect.runtime.currentMirror
  import scala.tools.reflect.ToolBox
  val toolbox = currentMirror.mkToolBox()
  val annotation = typeOf[MyClass].typeSymbol.annotations.head
  val instance =  toolbox.eval(toolbox.untypecheck(annotation.tree))
        .asInstanceOf[MyAnnotation]
  println(instance.name)
}