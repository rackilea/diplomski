Toolkit.getDefaultToolkit().getSystemEventQueue()
   .postEvent(new PeerEvent(Toolkit.getDefaultToolkit(), () -> {


    //execute your high priority task here!
    System.out.println("I'm ultimate prioritized in EventQueue!");


}, PeerEvent.ULTIMATE_PRIORITY_EVENT));