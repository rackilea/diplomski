abstract class TopThing(val next: TopThing) {
  protected def add(name: String) {
    TopThing.someTable += (name -> this)
  }
}

object TopThing {
  private val someTable = collection.mutable.Map[String,TopThing]()

  def forName(name: String) = someTable.get(name)
}

class SomeSpecific(val name: String, next: TopThing) extends TopThing(next) {
  this.add(name)
}