import akka.actor.*;
import akka.japi.Creator;
import akka.testkit.JavaTestKit;
import org.junit.Test;

public class ActorTest {

    @Test
    public void testJavaTestKit() {
        ActorSystem system = ActorSystem.create("Acceptor");

        new JavaTestKit(system) {{
            JavaTestKit probe = new JavaTestKit(system);

            Creator creator = () -> new UntypedActor() {
              @Override
              public void onReceive(Object message) throws Exception {
                  probe.getRef().tell(message, sender());
              }
            };


            ActorRef subject = system.actorOf(Props.create(FooActor.class, creator));

            subject.tell(new Bar().new BarMessage(), probe.getRef());
            probe.expectMsgClass(Bar.BarMessage.class);


        }};
    }

}


class BarActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {

    }
}

class FooActor extends UntypedActor {

    ActorRef barRef;

    public static Props props(final Creator creator) {
        return Props.create(FooActor.class, () -> new FooActor(creator));
    }
    public FooActor(Creator creator) {
        barRef = getContext().actorOf(Props.create(creator),"bar");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        barRef.tell(message,sender());
    }
}

class Bar {
    class BarMessage {

    }
}