public class SharedWaitingThreads {
    private ArrayList<ResponseToWait> queue;
    private static SharedWaitingThreads mySharedWaitingThreads;

    private SharedWaitingThreads() {
        queue = new ArrayList<>();
    }

    public static SharedWaitingThreads getInstance() {
        if(mySharedWaitingThreads == null)
            mySharedWaitingThreads = new SharedWaitingThreads();

        return mySharedWaitingThreads;
    }

    public ArrayList<ResponseToWait> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<ResponseToWait> queue) {
        this.queue = queue;
    }

    public void waitForAnswer(ResponseToWait r) throws InterruptedException {
        System.out.println("Petición registrada " + r.toString());
        synchronized(mySharedWaitingThreads) {
            mySharedWaitingThreads.getQueue().add(r);
            while(mySharedWaitingThreads.getQueue().contains(r)) {          
                mySharedWaitingThreads.wait();
            }
        }
    }



    public ResponseToWait answerWaitingThread(ResponseToWait r, boolean compareSeqNum) {
        ResponseToWait rw = null;
        synchronized(mySharedWaitingThreads) {
            for(ResponseToWait rwAux : mySharedWaitingThreads.getQueue()) {
                if(rwAux.equals(r)) {
                    rw = rwAux;
                    mySharedWaitingThreads.getQueue().remove(rwAux);
                    //every time a thread is released, notify to release the lock
                    mySharedWaitingThreads.notifyAll(); 
                    break;
                }
            }
        }
        return rw;
    }
}