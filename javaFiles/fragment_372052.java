trait IterableWrapperTrait[A] extends ju.AbstractCollection[A] {
  val underlying: Iterable[A]
  def size = underlying.size
  override def iterator = IteratorWrapper(underlying.iterator)
  override def isEmpty = underlying.isEmpty
}

case class IteratorWrapper[A](underlying: Iterator[A]) extends ju.Iterator[A] with ju.Enumeration[A] {
  def hasNext = underlying.hasNext
  def next() = underlying.next()
  def hasMoreElements = underlying.hasNext
  def nextElement() = underlying.next()
  def remove() = throw new UnsupportedOperationException
}