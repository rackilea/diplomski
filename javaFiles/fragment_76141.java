// define f
def f(x: Try[Message[_]]) = x match {
  case Success(result) => {
    println("The handler un-registration has reached all nodes")
  }
  case Failure(cause) => {
    println(s"$cause")
  }
}

// and later use it
vertx.eventBus.sendFuture("anAddress", "message 1").onComplete(f)