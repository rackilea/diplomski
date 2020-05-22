implicit class ArrayExtension[T <% Ordered[T]](val array: Array[T]) {
  def argSort = array.zipWithIndex.sortBy(_._1).map(_._2).toArray
}

val array = Array(5,4,3,2,0)
val array2 = Array(5f,4f,3f,2f,0f)

array.argSort foreach print //43210
println
array2.argSort foreach print //43210