public class MyGeneratorChildWorker extends UntypedActor {

    @Override
    public void postStop() {
        super.postStop();    
        System.out.println("Child Killed");
    }

    @Override
    public void onReceive(Object message) throws Exception {

        if (message instanceof ConfigMessage) {

            System.out.println("Created Child Worker");

            System.out.println("Doing Work:");
            try {

                for (int i = 0; i <= 100; i++) {


                    //update parent
                    this.context().parent().tell(new StatusUpdate(i));
                    long j = 1;
                     //waste loads of cpu cycles
                    while (j < 1E8) {
                        j = j + 1;
                    }
                }
            } catch (Exception ex) {

            }
            System.out.println("Done Work:");


        } else
            unhandled(message);
    }
}