import scala.collection.{Set => ISet}
import scala.collection.mutable.{Set => MSet}

class MyScala {
  var mySet: ISet[String] = null 

  def init(): Unit = {
     val s = MSet.empty[String]
     s + "Hello"
     s + "World"
     mySet = Set(s : _ *)
  }
}