import scala.reflect.ClassTag

object ScalaClass {
  def toArray[T <: AnyRef](coll: java.util.Collection[T])(implicit ct: ClassTag[T]): Array[T] =
    JavaClass.toArray[T](ct.runtimeClass.asInstanceOf[Class[T]], coll)
}