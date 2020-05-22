import scala.concurrent.Future;
import scala.reflect.ClassTag$;
import scala.reflect.ClassTag;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import static akka.pattern.Patterns.ask;
import akka.dispatch.*;

class AskTest{

  public static void main(String[] args) {
    ActorSystem system = ActorSystem.create();
    ActorRef ref = system.actorOf(Props.create(SimpleActor.class));

    ClassTag<NonSimpleObject> tag = ClassTag$.MODULE$.apply(NonSimpleObject.class);
    Future<NonSimpleObject> fut = ask(ref, "foo", 1000).mapTo(tag);
    fut.onComplete(new OnComplete<NonSimpleObject>(){
        public void onComplete(Throwable t, NonSimpleObject result){
          System.out.println(result.s);
        }
    }, system.dispatcher());
  }
}