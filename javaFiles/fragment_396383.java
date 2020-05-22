import scala.reflect.ClassTag
import scala.reflect.classTag

class DynamicaVariable {
    def cat(s1: List[Map[String, Double]]) = {
        println(s1)
    }
}

object DynamicaVariable{
    def main(args: Array[String]): Unit = {
        val obj = new DynamicaVariable
        val data = List(Map("a" -> 1.0, "b" -> 267.0, "c" -> 26.0, "d" -> 2.0)
                        , Map("a" -> 1.0, "b" -> 2678.0, "c" -> 40.0, "d" -> 2.0)
                        , Map("a" -> 4.0, "b" -> 267.0, "c" -> 26.0, "d" -> 2.0)
                        , Map("a" -> 1.0, "b" -> 2678.0, "c" -> 90.0, "d" -> 17.0))
        val functionName = "cat"
        val method = obj.getClass.getMethod(functionName, getClassOf(data).runtimeClass)

        method.invoke(obj,data)
    }

    def getClassOf[T: ClassTag](obj: T) = classTag[T]
}