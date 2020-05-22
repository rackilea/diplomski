while (true) {

        doSolvingLogicHere();

        shareUpdates(); // this method updates the shared state variable and is synhronized

        int count;
        int updates = 0;
        try {
             writeBarrier.await();
            if (threadsUpdatedSomething == 0) {
                updates = threadsUpdatedSomething;
                writeBarrier.reset();
                threadsUpdatedSomething -= 2; //'reset' the counter by decrementing 2
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TwinSolver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(TwinSolver.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (updates == 0) { //no thread updated something
            break;
        } else { // at least one of the threads updated something, solving should continue in both threads
            readUpdates();
        }
}