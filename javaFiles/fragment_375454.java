Executor exec = Executors.newFixedThreadPool(5);

for(String url: urls) 
   exec.submit(new UrlTask(urls));

// when finished
exec.shutdown();