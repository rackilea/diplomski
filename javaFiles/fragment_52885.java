import akka.actor._

import scala.concurrent.duration.FiniteDuration

object CounterActor {
  case class CountRequest(requestId : String, timeout : FiniteDuration)
  case class FinishCounting(requestId : String, originalSender : ActorRef)
  case class CountResponse(requestId : String, count : Int)
}

class CounterActor extends Actor with Timers {
  import CounterActor._
  var counters = Map[String, Int]()

  def receive = {
    case CountRequest(requestId, timeout) =>
      counters = counters.updated(requestId, 0)
      context.actorSelection("/user/*") ! Identify(requestId)
      timers.startSingleTimer("timeout", FinishCounting(requestId, sender()), timeout)

    case ActorIdentity(cId, ref) =>
      counters = counters.updated(cId.toString, counters.getOrElse(cId.toString, 0) + 1)
      ref.foreach { ref =>
        context.actorSelection(ref.path / "*") ! Identify(cId)
      }

    case FinishCounting(requestId, originalSender) =>
      originalSender ! CountResponse(requestId, counters.getOrElse(requestId, 0))
  }
}