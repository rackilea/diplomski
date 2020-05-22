class AsArrayList[T](input: List[T]) {
  def asArrayList : java.util.ArrayList[T] = new java.util.ArrayList[T](input.asJava)
}

implicit def asArrayList[T](input: List[T]) = new AsArrayList[T](input)

List(1000, 2000, 3000).asArrayList