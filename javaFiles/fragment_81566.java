import collection.JavaConverters._
val gen3 = udf(() => {
    val table = new java.util.Hashtable[String, String]()
    table.put("a", "b")
    Map(table.entrySet.asScala.toSeq.map(x => x.getKey -> x.getValue) :_*)
})