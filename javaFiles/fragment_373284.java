private ExecutorService executorService;
 :
executorService = Executors.newSingleThreadExecutor();
 :
/*
 * When EDT receives a request for a card it calls readCard(),
 * which queues the work to the *single* thread.
 */
public void readCard() throws Exception {
    executorService.execute(new Runnable() {
        public void run() {
            if (buffer.isEmpty()) {
                /*
                 * fill() takes 1/4 second (simulated by Thread.sleep)
                 */
                buffer.fill();
            }
            Card card = buffer.get(); // empties buffer
            /*
             * Send card to CPU
             */
            CPU.sendMessage(card); // <== (A) put card in msg queue
            /* 
             * No race!  Next request will run on same thread, after us.
             */
            buffer.fill(); //         <== (B) pre-fetch next card
            return;
        }
    });
}

/*
 * IMPORTANT MODIFICATION HERE - - -
 *
 * buffer fill() method has to remove item from the list that is the
 * model behind a JList - only safe way is to do that on EDT!
 */
private void fill() {
    SwingUtilities.invokeAndWait(new Runnable() {
        /*
         * Running here on the EDT
         */
        public void run() {
            /*
             * Hopper not empty, so we will be able to read a card.
             */
            buffer = readHopper.pollLast();  // read next card from current deck
            fireIntervalRemoved(this, readHopper.size(), readHopper.size()); 
            gui.viewBottomOfHopper(); // scroll read hopper view correctly
        }
    });
    // back to my worker thread, to do 1/4 sec. of heavy number crunching ;)
    // while leaving the GUI responsive 
    Thread.sleep(250);
     :
    etc.
}