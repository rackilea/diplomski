public static void main(String[] args) {

     //Assume that I have request object that contain arrayList of names
     //and VectorList is container for each request result

     ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
     Vector<Result> vectorList = new Vector<Result();

     for (int i=0;i<request.size();i++) {
          threadExecutor.execute(new QueryTask(request.get(i).getNames, vectorList)
     }

      threadExecutor.shutdown();
      threadExecutor.awaitTermination(aReallyLongTime,TimeUnit.SECONDS);

      response.setResult(vectorList)

}