implicit class MyExtensions[T](ts: mutable.TreeSet[T]) extends AnyVal {
  def pollFirst(): T = {
    val elem = ts.head
    ts -= elem
    elem
  }
}