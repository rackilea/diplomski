public class Thread1 extends Thread {
    private Syncc syncc;

    public Thread1(Syncc syncc) {
        this.syncc = syncc;
    }

    public void run() { 
        this.syncc.me("T1:");
    }   
}