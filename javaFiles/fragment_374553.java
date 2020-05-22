import java.util.{List => JList, ArrayList}
import scala.collection.JavaConversions._

val jul1: JList[String] = new ArrayList[String]; jul1.add("Boo!")

val sb1 = jul1.toBuffer
val ss1 = jul1.toSeq // Same result as toBuffer