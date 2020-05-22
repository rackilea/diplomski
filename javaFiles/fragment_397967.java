// Initialize Weld
    Weld theWeld = new Weld();
    WeldContainer theContainer = theWeld.initialize();


    // Execute the run method
    theContainer.instance().select(Main.class).get().run();


    // Shutting down Weld again
    theWeld.shutdown();