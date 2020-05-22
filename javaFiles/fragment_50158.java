import scala.collection.JavaConversions._

val m = new java.util.HashMap[String, Object]()
m.put("Foo", java.lang.Boolean.TRUE)
m.put("Bar", java.lang.Integer.valueOf(1))

val m2: Map[String, Any] = m.toMap
println(m2);