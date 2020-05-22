public class Account2 implements Runnable
   public class Account3 implements Runnable

   public interface ThreadFactory {
        Thread newTread(Runnable runnable);
     }

    public class MyThreadFactory implements ThreadFactory {
     private String name;
     public MyThreadFactory(String name){
       this.name = name;
       }

    @Override
    public Thread newTread(Runnable runnable) {
     Thread t = new Thread(runnable);
    }

    // here addition logic (deposit, getBalance, ...)


    public class Main {
       public static void main(String[] args) {
       MyThreadFactory factory=new MyThreadFactory("MyThreadFactory");
       Thread th1 = factory.newTread(new Account1());
       Thread th2 = factory.newTread(new Account2());   
       Thread th3 = factory.newTread(new Account3());   
       th1.start();
       th2.start();
       th3.start();