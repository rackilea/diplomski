case class AskQuestion(id:Long, accountName:String, question:String)
case class QuestionAnswer(id:Long, answer:String)
case class QuestionTimeout(id:Long)

class QuestionMaster(tcpHandler:ActorRef) extends Actor{
  def receive = {
    case ask:AskQuestion => 
      val asker = context.actorOf(Props(classOf[QuestionAsker], tcpHandler), ask.id.toString)
      asker.forward(ask)

    case answer:QuestionAnswer =>
      val asker = context.child(answer.id.toString)
      asker match{
        case Some(ref) => ref.forward(answer)                    
        case None => 
          //handle situation where there is no actor to handle the answer
      }
  }
}

class QuestionAsker(tcpHandler:ActorRef) extends Actor{
  import context._
  import concurrent.duration._

  def receive = {
    case ask:AskQuestion =>
      //Do whatever other prep work here if any then send to tcp actor
      tcpHandler ! ask
      setReceiveTimeout(5 seconds)
      become(waitingForAnswer(ask, sender))
  }

  def waitingForAnswer(ask:AskQuestion, caller:ActorRef):Receive = {
    case ReceiveTimeout =>
      caller ! QuestionTimeout(ask.id)
      context stop self
    case answer:QuestionAnswer =>
      //do any additional work to prep response and then respond
      caller ! answer
      context stop self
  }
}