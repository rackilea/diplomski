public class ThreadExample {
    public static void main(String args[]){
        new DeamonThread().start();
        for(int i=0;i<5;i++){
            System.out.println("Main thread is running "+ i+" time");
        }

    }
}

class DeamonThread extends Thread{
    DeamonThread(){
        setDaemon(true);
    }
    public void run(){
        int count=0 ;
        while (true) {
            System.out.println("Hello from Deamon Thread "+count++) ;
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}