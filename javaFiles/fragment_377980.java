public class ChickenCluckMaster extends UntypedActor {

    private FizzBuzz fizzBuzz;

    public ChickenCluckMaster(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public void onReceive(Object message) throws Exception {
        if (message instanceOf CreateDetector) {
            getContext().actorOf(
                Props.create(ChickenCluckDetector.class, getSelf); // Create child
        } else if (message instanceof Cluck) {
            fizzBuzz.onCluck(cluck);
        } else {
            unhandled(message);
        }
    }

}

public class ChickenCluckDetector extends UntypedActor {

    private ActorRef master;

    public ChickenCluckDetector(ActorRef master) {
        this.master = master;
    }

    public void onReceive(Object message) throws Exception { 
        if (message instanceof Cluck) {
            Cluck cluck = (Cluck) message;
            master.tell(cluck, getSelf);
        } else {
            unhandled(message);
        }
    }

}