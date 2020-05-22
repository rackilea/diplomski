object DeadLock {

  import scala.concurrent._
  import scala.concurrent.duration.Duration
  import scala.concurrent.ExecutionContext.Implicits.global

  val foo: Int = Await.result(Future(calc()), Duration.Inf)

  def printFoo(): Unit = {
    println(s"Foo = $foo")
  }

  private def calc(): Int = {
    println("Before calc")
    42
  }
}


def test(): Unit = {
  println("Before printFoo")
  DeadLock.printFoo()
  println("After printFoo")
}