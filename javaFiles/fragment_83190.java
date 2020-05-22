final BlockingQueue<Boolean> verificationQueue = new ArrayBlockingQueue<Boolean>(1);

p.lookup(lookupKey, new Continuation<PastContent, Exception>()
{
  public void receiveResult(PastContent result)
  {
    P2PPKIContent content = (P2PPKIContent) result;
    if(content !=null){
       verificationQueue.put(true);
    }
  }
  public void receiveException(Exception result)
  {
    System.out.println("Error looking up " + lookupKey);
    verificationQueue.put(false);
  }
});

return verify.take(); //blocks until an item has been put on the queue