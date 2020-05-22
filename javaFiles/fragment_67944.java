public static class A {
}

public  static void main(String[] args) throws Exception{
    A a = new A();

    ReferenceQueue<A> rq = new ReferenceQueue<A>();
    WeakReference<A> aref = new WeakReference<A>(a, rq);    
    a = null;

    //aref.get() should be a, aref.isEnqueued() should return false, rq.poll() should return null
    System.out.println( "0: " + aref + " : " + aref.get() + " : " + aref.isEnqueued() + "  " + rq.poll() ); 

    Thread.sleep(1000);

    System.out.println("Running GC.");
    Runtime.getRuntime().gc();  //let GC clear aref
    System.out.println("GC ran.");

    //aref.get() should be null, aref.isEnqueued() should return false, rq.poll() should return null
    System.out.println( "1: " + aref + " : " + aref.get() + " " + aref.isEnqueued() + "  " + rq.poll()  );   

    //give some time for GC to enqueue aref
    Thread.sleep(1000);

    //ref.get() should be null, aref.isEnqueued() should return true, rq.poll() should return aref
    System.out.println( "2: " + aref + " : " + aref.get() + " " + aref.isEnqueued() + "  " + rq.poll() );  
}