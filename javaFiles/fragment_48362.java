test("extractSessions") {
  new Object3 should be (new Object3)
  new Object3 shouldEqual (new Object3)
}

class Object3 {
  // PS: A little code improvement: 
  // I removed the old ugly, java like
  // val pippo: java.lang.String = "blah" 
  // with the more scala-like:  
  val pippo = "blah"  // Scala guesses the type -> String
  val pappo = 0L      // again -> Long

  def canEqual(a: Any) = a.isInstanceOf[Object3]

  override def equals(that: Any): Boolean =
    that match {
      case that: Object3 => that.canEqual(this) && this.hashCode == that.hashCode
      case _             => false
  }

  override def hashCode: Int = (41 * (41 + pippo.hashCode) + pappo.hashCode)
}