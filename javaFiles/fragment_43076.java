import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentDemo extends Thread{
    static ArrayList l=new ArrayList();
    public void run()
    {

        System.out.println("child thread updating list");
        l.add("D");
        System.out.println(l);

    }

    public static void main(String args[]) throws InterruptedException
    {  

        //----> Main thread starts here
        l.add("A");
        l.add("B");
        l.add("c");  

     //----> l now contains A,B,C  

     ConcurrentDemo c=new ConcurrentDemo();  

      //----> You have started a second thread here
      c.start();    

      //-----> Its not determined, which line will be executed first from now on, as 2 threads are running parallelly, the ConcurrentModificationException most likely occur in cases, when the "l.add("D");" called within the "run();" method AFTER the Iterator has been created.   

      System.out.println(l);
      Iterator itr =l.iterator();
      while(itr.hasNext())
      {
          String s1=(String)itr.next();
          System.out.println("main thread list:" + s1);
          Thread.sleep(3000);
      }
      System.out.println(l);
    }
}