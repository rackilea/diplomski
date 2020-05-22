package my.package

import scala.tools.reflect.ToolBox
import scala.reflect.runtime.universe._

case class Animal(id: Int, name: String)

object App {    
  val any: Any = Animal(1, "simba")
  val className = "my.package.Animal"

  val mirror = runtimeMirror(getClass.getClassLoader)
  val tb = mirror.mkToolBox()
  tb.eval(tb.parse(
    s"""
      import my.package.App._
      val animal = any.asInstanceOf[$className]
      println(animal.id)
      println(animal.name)
    """))
}