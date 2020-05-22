private final int numOfCrawlers;
private int waiting;

public boolean shouldTryAgain(){
    synchronized(this){
        waiting++;
        if(waiting>=numOfCrawlers){
            //Everybody is waiting, terminate
            return false;
        }else{
            wait();//spurious wake up is okay
            //waked up for whatever reason. Try again
            waiting--;
            return true;
        }
    }

public void hasEnqueued(){
    synchronized(this){
        notifyAll();
    }
}