class ABRoutingLogic(a:ActorRef, b:ActorRef) extends RoutingLogic{
  val aRoutee = ActorRefRoutee(a)
  val bRoutee = ActorRefRoutee(b)

  def select(msg:Any, routees:immutable.IndexedSeq[Routee]):Routee = {
    msg match{
      case "A" => aRoutee
      case _ => bRoutee
    }
  }
}