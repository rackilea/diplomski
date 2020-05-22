ExecutorService executor = Executors.newFixedThreadPool(10);            
List<Future<String>> list = new ArrayList<Future<String>>();            
Callable<String> callable = new MyCallable();

for (int i = 0; i < 100; i++)
{              
  Future<String> future = executor.submit(callable);              
  list.add(future);
}