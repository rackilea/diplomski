case class ABRoutingGroup(a:ActorRef, b:ActorRef) extends Group { 
  val paths = List(a.path.toString, b.path.toString)

  override def createRouter(system: ActorSystem): Router =
    new Router(new ABRoutingLogic(a, b))

  val routerDispatcher: String = Dispatchers.DefaultDispatcherId
}