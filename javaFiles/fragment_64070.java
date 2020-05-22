class MyThread extends Thread {
     private ApplicationContext context;
     private int hashCode;
     public MyThread(ApplicationContext context) {
         this.context = context;
     }
     public void run() {
         hashCode = System.identityHashCode(context.getBean("MySingeltonDB"));
     }
     public int getHashCode() { 
         return hashCode;
     }
}