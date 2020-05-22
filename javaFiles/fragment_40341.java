Future<MyResult> futureResult = executor.submit(new Callable<MyResult>(){
   void call(){
       return request.ExecuteOperation();
   }
});
return futureResult.get(2, TimeUnit.MINUTES);