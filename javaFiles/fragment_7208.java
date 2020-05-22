object RoutingTest extends App{
  val system = ActorSystem()
  val a = system.actorOf(Props(classOf[PrintingActor], "A"))
  val b = system.actorOf(Props(classOf[PrintingActor], "B"))
  val router = system.actorOf(Props.empty.withRouter(ABRoutingGroup(a,b)))

  router ! "A"
  router ! "B"

}