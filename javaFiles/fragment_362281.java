val jmap = new HashMap[String, Object]
  jmap.put("1", new Date)

  import scala.collection.JavaConverters._

  val smap = jmap.asScala.mapValues(_.asInstanceOf[Any]).toMap
  test(smap)

  def test(m: Map[String, Any]): Unit = {
    println(m)
  }