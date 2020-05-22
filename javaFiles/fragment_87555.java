class Super {
  def foo() { bar() }
  def bar() { println("BAR")}
  def main( args : Array[String]) {
    foo()
  }
}

object Super extends Super {
}

object Sub extends Super {
  override def bar() { println("bar")}
}