public class MyActor extends UntypedActor
{
 @Override
  public void onReceive(Object message) throws Exception 
  {
     System.out.println("MyActor received : "+message.toString());
  }
}

public class DeadLettersHandler extends UntypedActor
{
  public void onReceive(Object deadLetter) throws Exception
  {
   System.out.println("DeadLettersHandler received : "+deadLetter.toString());
  }
}


public class DeadLetterTest 
{
   public static void main(String[] args)
   {
     ActorSystem MyActorSystem = ActorSystem.create("MyActorSystem");
     ActorRef existingActor = MyActorSystem.actorOf(Props.create(MyActor.class),"ExistingActor");
     ActorRef DLH = MyActorSystem.actorOf(Props.create(DeadLettersHandler.class), "DeadLetterHandler");
     MyActorSystem.eventStream().subscribe(DLH, DeadLetter.class);
     ActorSelection nonExist = MyActorSystem.actorSelection("akka://user/MyActorSystem/NonExistingActor");
     existingActor.tell("Hello Akka", existingActor);
     nonExist.tell("Hello Akka", DLH);
     MyActorSystem.shutdown();
    }
}

 output:

 MyActor received : Hello Akka
 DeadLettersHandler received : DeadLetter(Hello Akka,Actor[akka://MyActorSystem/user/DeadLetterHandler#-3707992],Actor[akka://MyActorSystem/deadLetters])
 [INFO] [10/10/2013 15:43:43.343] [MyActorSystem-akka.actor.default-dispatcher-6] [akka://MyActorSystem/deadLetters] Message [java.lang.String] from Actor[akka://MyActorSystem/user/DeadLetterHandler#-3707992] to Actor[akka://MyActorSystem/deadLetters] was not delivered. [1] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.