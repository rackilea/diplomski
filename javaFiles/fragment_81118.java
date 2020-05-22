import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;


public class MyApp {

    public static void main(String[] args) {
        // Do some stuff before starting the actor system.
       System.out.println("Start Actor System");
       ActorSystem actorSystem = ActorSystem.create("myapp-actorsys");
       ActorRef destructor = actorSystem.actorOf(Props.create(Destructor.class));

       //Java process won't shut down before actor system stops
       //Send message after timeout to stop system

       actorSystem.scheduler().scheduleOnce(Duration.create(10, TimeUnit.SECONDS),
               destructor, new ShutdownNow(), actorSystem.dispatcher(), null);
    }

    public static class Destructor extends UntypedActor {

        public Destructor() {

        }

        @Override
        public void onReceive(Object msg) {
            if(msg instanceof ShutdownNow) {
                //Shutdown system to stop java process
                System.out.println("Stop Actor System");
                getContext().system().shutdown();
            }
        }
    }

    public static class ShutdownNow {

    }
}