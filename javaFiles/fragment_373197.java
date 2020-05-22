public void runOperation(Operation o) throws Exception{ 
     logOperationStarted();
     try{
        o.execute();
     }finally{
       logOperationFinished();
     }
}