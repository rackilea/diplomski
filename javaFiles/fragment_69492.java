public class NonSimpleObject{
  public final int i;
  public final String s;

  public NonSimpleObject(String s, int i){
      this.s = s;
      this.i = i;
  }
}

public class SimpleActor extends UntypedActor{
  public SimpleActor(){

  }
  public void onReceive(Object msg){
    getSender().tell(new NonSimpleObject("foo", 11), getContext().self());
  }
}

import scala.concurrent.Future;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import static akka.pattern.Patterns.ask;
import akka.dispatch.*;

class AskTest{

  public static void main(String[] args) {
    ActorSystem system = ActorSystem.create();
    ActorRef ref = system.actorOf(Props.create(SimpleActor.class));
    Future<Object> fut = ask(ref, "foo", 1000);
    fut.onComplete(new OnComplete<Object>(){
        public void onComplete(Throwable t, Object result){
          System.out.println(((NonSimpleObject)result).s);
        }
    }, system.dispatcher());
  }
}