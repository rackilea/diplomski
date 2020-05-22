for(Query query : queries){
  boolean flag = false;
  while(!flag){
    try{
      query.execute();
      flag = true;
    } catch (TransientException e){
      log("Retrying query "+query);
      Thread.sleep(1*1000); //1 second
    }
  }
}