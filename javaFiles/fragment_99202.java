public Bitmap barrel (Bitmap input, float k){
  ...

  // replace the j, i for loops:
  int jMax = input.getHeight();
  ExecutorService threadPool = Executors.newFixedThreadPool(2);
  int jMid = jMax / 2;

  FutureTask<PartialResult> task1 = treadPool.submit(new PartialProcessing(0, jMid - 1, ...)); 
  FutureTask<PartialResult> task2 = treadPool.submit(new PartialProcessing(jMid, jMax - 1(?) ...)); 

  PartialResult result1 = task1.get(); // blocks until the thread returns the result
  results1.fill(arr);
  PartialResult result2 = task2.get(); // blocks until the thread returns the result
  results2.fill(arr);      
}