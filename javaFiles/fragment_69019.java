import scala.collection.JavaConverters._
import java.util.{List=>JavaList}
import scala.collection.immutable.{List => ScalaList}
import scala.collection.mutable.{MutableList => ScalaMutableList}

val a : ScalaList[ScalaMutableList[String]] = List(MutableList())
val b: ScalaList[JavaList[String]]= a.map(_.asJava)
val c: JavaList[JavaList[String]] = b.asJava