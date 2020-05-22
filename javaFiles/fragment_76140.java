vertx.eventBus.sendFuture("anAddress", "message 1").onComplete { x: Try[Message[_]] =>
  x match {
    case Success(result) => {
      println("The handler un-registration has reached all nodes")
    }
    case Failure(cause) => {
      println(s"$cause")
    }
  }
}