import java.util.concurrent.{Callable, ExecutorService, Executors}
import scala.collection.mutable

def testSet(set: mutable.Set[Int]) {
  val e: ExecutorService = Executors.newFixedThreadPool(5)
  val tasks = for (i <- 0 to 50000) yield {
    e.submit(new Callable[Unit]() {
      override def call() {
        for (j <- 0 to 10) {
          set.add(i + j)

          // This will throw a Null Pointer Exception for the non-concurrent version
          // This is because it is trying to remove something that another thread already removed.
          set.remove(i + j) 
        }
      }
    })
  }
  for (result <- tasks) result.get()
  e.shutdown()
}

// Can't check the type! They have the same type.
val regularSet: mutable.Set[Int] = mutable.Set[Int]()
val concurrentSet: mutable.Set[Int] = java.util.concurrent.ConcurrentHashMap.newKeySet[Int]().asScala

testSet(concurrentSet) // Success!
testSet(regularSet) // FAILS! Almost always throws a NullPointerException on my system.