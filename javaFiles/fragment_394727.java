class Foo(actor: => Actor) extends Actor {
  def act {
    loop {
      react {
        case x: String => actor ! x
      }
    }
  }
}

lazy val foo = new Foo(foo)

foo.start

foo ! "bar"