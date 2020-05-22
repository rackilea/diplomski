case class Foo[T](v: T, f: T => Int)

def doSomething(x: Any): Unit = x match {
  case Foo(v, f) => println(f(v))
  case _ => println("whatever")
}