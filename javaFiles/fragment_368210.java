@Override
    public synchronized void onNewSetupMessage() {
        System.out.println("Intermediate Node " + id + " got notified about setup message");
        // pass setup message to next neighbor
        Thread smService = new Thread(new SetupMessageSender(this.setupMessageListener));
        smService.start();
    }