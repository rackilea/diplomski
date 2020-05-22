object ItemProviderTest extends App{
  import ItemProvider._
  val system = ActorSystem("test")
  import system.dispatcher
  val provider = system.actorOf(Props[ItemProviderRouter])

  implicit val timeout = Timeout(10 seconds)
  for(i <- 1 until 20){
    val afut = provider ? GetItems("a")
    val bfut = provider ? GetItems("b")

    afut onSuccess{
      case ItemResults(items) => println(s"got items list of $items for project a")
    }

    bfut onSuccess{
      case ItemResults(items) => println(s"got items list of $items for project b")
    }    
  }
}