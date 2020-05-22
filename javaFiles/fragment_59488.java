public class NameOutput extends Thread {
    static final int N = 5;
    static int activeThread = 0;
    static final Object lock = new Object(); // shared monitor lock

    public static void main(String[] args){

        for (int i = 1; i <= N; i++) {
            new NameOutput().start();
        }
    }

    @Override
    public void run(){
        while(true){
            this.printThreadName();
        }

    }
    private void printThreadName(){
        synchronized (lock) {
            String threadName = "Thread-"+ activeThread;
            //Check if thread is in the right order
            if(!threadName.equals(this.getName())){
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    System.out.println(this.getName()+" was interrupted!");
                }
            }else{
                System.out.println(this.getName());
                activeThread = (activeThread + 1) % N;
                lock.notifyAll();
            }
        }
    }
}