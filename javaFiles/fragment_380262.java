Runnable dbThread = new Runnable() {
    @Override
    public void run() {
        dodbwork(); //as mentioned by Nicolas do your Database work here
    }
};
         Runnable uiThread = new Runnable() {
    @Override
    public void run() {
        doUIUpdates(); // and your UI work here
        try {
            Thread.sleep(300);//telling your thread to wait in  milliseconds
        } catch (InterruptedException ex) {
            Logger.getLogger(saveprogressbar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
};
         dbThread.run();//this is how you run your thread later on
         uiThread.run();