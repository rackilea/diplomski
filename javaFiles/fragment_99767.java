public class SyncTest {
     static int[] balances = new int[]{ 1,10,100,1000,10000};
public static void main(String[] args) {
    // TODO Auto-generated method stub
    SyncTest test = new SyncTest();
    Client c1 = new Client("0", test,1);
    Client c2 = new Client("1", test,10);
    Client c3 = new Client("2", test,100);
    Client c4 = new Client("3", test,1000);
    Client c5 = new Client("4", test,10000);

    Thread[] threads = new Thread[5];
    threads[0] = new Thread(c1);
    threads[1] = new Thread(c2);
    threads[2] = new Thread(c3);
    threads[3] = new Thread(c4);
    threads[4] = new Thread(c5);

    for(int i=0;i<5;i++){
        threads[i].start();
    }
    for(int i=0;i<5;i++){
        try{
            threads[i].join();
        }
        catch(InterruptedException ex){
        }
    }


    System.out.println("Final balances are ");
    for(int i=0;i<5;i++){
        System.out.print(balances[i] + " , " );
    }
}

ConcurrentHashMap<String,String> callers = new ConcurrentHashMap<String, String>();

public void deposit(Client c) throws InterruptedException{
    String id = c.id;
    int amount = c.amount;
    if(id == null) return ;

   // callers is a ConcurrenthashMap<String,String>
    System.out.println("Client " + id + " in deposit. Checking if already running..");
    while( callers.get(id) != null && !(callers.get(id).equals("X"))) {
       synchronized(id){
        System.out.println("Client " + id + " in deposit. Found already running,going to wait..");
        id.wait(); 
     }
   }
    if(callers == null){
        throw new NullPointerException("Callers is null!!");
    }

    System.out.println("Client " + id + " in deposit. Found not running already,  Now running..");
    callers.put(id,id);
    int index = Integer.parseInt(id);
    balances[index] += amount;
    Thread.sleep(2000);
    synchronized(id){
        String old = callers.put(id,"X");
        id.notifyAll();
       System.out.println("Client " + id + " in deposit. Finished running ,  Notifying..");
    }
}

static class Client implements Runnable {
    String id ;
    SyncTest test;
    int amount;
    Client c = this;

    Client(String id , SyncTest t, int am){
        this.id = id;
        test = t;
        amount = am;
    }

    public void run(){
        process();
    }

    void process(){
        System.out.println("Client " + id + " processing ...");
        try{
            Thread.sleep(1000);
            Thread t1 = new Thread(
                new Runnable(){
                    public void run(){
                        try{
                            test.deposit(c);
                        }
                        catch(InterruptedException ex){
                        }
                    }
                }
            );
            Thread t2 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );

            Thread t3 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );

            Thread t4 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );

        /*  Thread t5 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );

            Thread t6 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );
            Thread t7 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );
            Thread t8 = new Thread(
                    new Runnable(){
                        public void run(){
                            try{
                                test.deposit(c);
                            }
                            catch(InterruptedException ex){
                            }
                        }
                    }
                );
        */  
            t1.start();t2.start();t3.start();t4.start();//t5.start();t6.start();t7.start();t8.start();
            t1.join();t2.join();t3.join();t4.join();//t5.join();t6.join();t7.join();t8.join();

        }
        catch(InterruptedException ex){
            System.out.println(" Exception " + ex.getMessage());
        }
        System.out.println("Client " + id + " done #####");
    }
}