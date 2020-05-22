// scala Set to Java Set Converters
def scalaToJavaSetConverter(scalaSet: Set[Long]): java.util.Set[Long] = {
    val javaSet = new java.util.HashSet[Long]()
    scalaSet.foreach(entry => javaSet.add(entry))
    javaSet
}