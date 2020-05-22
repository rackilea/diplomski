public void workOrRequeue(){
    for(;;){
       Future<?> future = e.submit(someCallable());
       try{
          future.get();
          return;
       }catch(ExecutionException ex){
          //maybe log, ex.printStackTrace();
       }
    }
}