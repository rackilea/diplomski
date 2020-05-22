class ObjectArrayTools[T <: AnyRef](a: Array[T]) {                  
   def binarySearch(key: T) = {
     java.util.Arrays.binarySearch(a.asInstanceOf[Array[AnyRef]],key)
   }
}
implicit def anyrefarray_tools[T <: AnyRef](a: Array[T]) = new ObjectArrayTools(a)

scala> Array("a","fish","is","some","thing").binarySearch("some")
res26: Int = 3
scala> Array("a","fish","is","some","thing").binarySearch("bye")  
res28: Int = -2