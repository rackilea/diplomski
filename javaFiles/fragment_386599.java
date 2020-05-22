public void doWork(long id){
    Future<WorkResult> futureResult = async.doWork(id);
    ... do other stuff        
    WorkResult result = futureResult.get(); //the invocation will block until the result is calculated

}