import akka.actor._
import scala.concurrent.Future
import akka.pattern._
import concurrent.duration._ 
import akka.util.Timeout

class ItemProviderRouter extends Actor{
  import ItemProvider._

  def receive = {
    case get @ GetItems(project) =>

      //Lookup the child for the supplied project.  If one does not
      //exist, create it
      val child = context.child(project).getOrElse(newChild(project))
      child.forward(get)
  }

  def newChild(project:String) = {
    println(s"creating a new child ItemProvider for project $project")
    context.actorOf(Props[ItemProvider], project)
  }

}

object ItemProvider{
  case class GetItems(project:String)
  case class Item(foo:String)
  case class LoadedItems(items:List[Item])
  case object ClearCachedItems
  case class ItemResults(items:List[Item])
}

class ItemProvider extends Actor with Stash{
  import ItemProvider._  

  //Scheduled job to drop the cached items and force a reload on subsequent request
  import context.dispatcher
  context.system.scheduler.schedule(5 minutes, 5 minutes, self, ClearCachedItems)

  def receive = noCachedItems

  def noCachedItems:Receive = {
    case GetItems(project) =>
      stash()      
      fetchItems(project)
      context.become(loadingItems)


    case ClearCachedItems =>
      //Noop
  }

  def loadingItems:Receive = {
    case get:GetItems => stash

    case LoadedItems(items) =>
      println(s"Actor ${self.path.name} got items to cache, changing state to cachedItems")
      context.become(cachedItems(items))
      unstashAll()    

    case ClearCachedItems => //Noop      
  }

  def cachedItems(items:List[Item]):Receive = {
    case GetItems(project) =>
      sender ! ItemResults(items)

    case ClearCachedItems =>
      println("Clearing out cached items")
      context.become(noCachedItems)       

    case other =>
      println(s"Received unexpected request $other when in state cachedItems")          
  }

  def fetchItems(project:String){
    println(s"Actor ${self.path.name} is fetching items to cache")

    //Simulating doing something that results in a Future
    //representing the items to cache    

    val fut = Future{
      Thread.sleep(5000)
      List(Item(s"hello $project"), Item(s"world $project"))
    }

    fut.map(LoadedItems(_)).pipeTo(self)
  }
}