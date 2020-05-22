public class Main extends Thread {
    int counter= 0;
    public static void main(String args[]) throws Throwable {      
        Main t[] = new Main[100];
        for (int j=0; j<100;j++) {
            t[j] = new Main();
            t[j].start();       
        }          
    }
    public void run() {
        try {
            System.out.println("thread " + Thread.currentThread().getName()+" step "+counter++);
        } 
        catch (Throwable t) { 
            t.printStackTrace();
        }
    }
}