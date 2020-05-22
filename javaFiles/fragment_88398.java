@Override
public void run() {
    if(b.getField()){
        while(true) {
            System.err.println("Waiting...");
            try { Thread.sleep(1000); }
            catch(InterruptedException ie) { return; }
        }
    }
}