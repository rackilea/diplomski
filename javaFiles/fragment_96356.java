class RequeableWorker implement Runnable{
  private final ExecutorService e;
  public RequeableWorker(ExecutorService e){this.e =e;}

  public void run(){
     try{
        //do work
     }catch(RuntimeException ex){
        e.submit(this);
        throw ex;
     }
  }
}