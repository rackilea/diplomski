final SettableFuture<Boolean> verify = new SettableFuture<Boolean>();

p.lookup(lookupKey, new Continuation<PastContent, Exception>()
{
  public void receiveResult(PastContent result)
  {
    P2PPKIContent content = (P2PPKIContent) result;
    if(content !=null){
       verify.set(true);
    }
  }
  public void receiveException(Exception result)
  {
    System.out.println("Error looking up " + lookupKey);
    verify.set(false);
  }
});

return verificationQueue.get(); //this will block until verify has been set!