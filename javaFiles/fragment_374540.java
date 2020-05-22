public class Resource{
  Queue<String> semaphore = new LinkedList<String>();
  Queue<String> sortedResult = new LinkedList<String>();

  public synchronized addStrings(List<String> words){//for reader
    semaphore.addAll(words);
    notify();
  }//

  public synchronized String getString(){//for workers
    while(semaphore.isEmpty())
       try{ wait();}
       catch(InterruptedException e){}
    return semaphore.remove();
  }
}