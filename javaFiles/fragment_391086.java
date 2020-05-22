public class MyGeneratorMaster extends UntypedActor {

    private int completed = 0;

    @Override
    public void postStop() {
        super.postStop();   
        System.out.println("Master Killed");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof actors.messages.ConfigMessage) {
            ConfigMessage config = (ConfigMessage) message;

            System.out.println("Received Config:" + config.getConfig());

            //Need to spawn child actor here..
            ActorRef child = this.getContext().actorOf(new Props(MyGeneratorChildWorker.class));

            //make the child thread do stuff
            child.tell(new ConfigMessage("doSomething!"));

            child.tell(akka.actor.PoisonPill.getInstance());//kill the child after the work is complete...

        } else if (message instanceof StatusUpdate) {
            System.out.println("Got Status Update");
            completed = ((StatusUpdate) message).getProgress();
        } else if (message instanceof StatusMessage) {
            System.out.println("Got Status Message");
            getSender().tell(new ResultMessage("Status: " + completed + "%"), getSelf());

            if(completed == 100)
            {
                //kill this actor, we're done!
                //could also call stop...
                this.getSelf().tell(akka.actor.PoisonPill.getInstance());
            }
        } else {
            System.out.println("unhandled message"+message.toString());
            unhandled(message);
        }

    }
}