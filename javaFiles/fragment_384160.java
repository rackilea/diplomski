public AudioRTPRecv() {
    MediaLocator mrl= new MediaLocator("rtp://192.168.1.100:49151/audio/1");

    // Create a player for this rtp session
    try {
        player = Manager.createPlayer(mrl);
    } catch (Exception e) {
        System.err.println("Error:" + e);
        return;
    }

    if (player != null) {
        player.addControllerListener(this);
        player.realize();
    }
}

public synchronized void controllerUpdate(ControllerEvent ce) {
    System.out.println(ce);
    if(ce instanceof TransitionEvent) {
        if (((TransitionEvent)ce).getCurrentState() == Processor.Realized) {
            player.start();
            System.out.println("starting player now");
        }
    }
}