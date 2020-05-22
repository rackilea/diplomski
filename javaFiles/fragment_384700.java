import java.util.LinkedHashMap
import scala.collection.JavaConversions.mapAsScalaMap

object App{
  implicit def wrapLhm[K,V,G](i:LinkedHashMap[K,LinkedHashMap[G,V]]):LHMWrapper[K,V,G] = new LHMWrapper[K,V,G](i)

  def main(args: Array[String]){
    println("Hello World!")
    val lhm = new LinkedHashMap[String, LinkedHashMap[String,String]]()
    val inner = new LinkedHashMap[String,String]()
    inner.put("one", "one")
    lhm.put("outer",inner);
    val s = lhm.getSeq()
    println(s.toString())
  }
  class LHMWrapper[K,V,G](value: LinkedHashMap[K,LinkedHashMap[G,V]]){
    def getSeq():Seq[ (K, Seq[(G,V)])] = mapAsScalaMap(value).mapValues(mapAsScalaMap(_).toSeq).toSeq
  }
}