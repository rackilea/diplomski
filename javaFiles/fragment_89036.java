private ConnectionInterface  connectWithTimeout() throws MalformedURLException, Exception {
        int repeatCount = 0;

        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Object> task = new Callable<Object>() {
            public Object call() throws InterruptedException, MalformedURLException, Exception {
                return connectWithNoTimeout();  //This is the method that takes to long. If this method takes more than 5 seconds, I want to cancel and retry for 3 more times. Then abort completely.
            }
        };

        while (repeatCount < 3){
          Future<Object> future = executor.submit(task);
          try {
              Object result = future.get(5, TimeUnit.SECONDS);
              break;

          } catch (TimeoutException ex) {
            repeatCount++;
            System.out.println( "Timeout Occured");

          } catch (InterruptedException e) {
            System.out.println( " "InterruptedException Occured");
            break; 

          } catch (ExecutionException e) {
              System.out.println( "ExecutionException Occured");
            break;    

          } finally {

              future.cancel(true); // here the method gets canceled. How do I retry it?
          }
        }
        System.out.println( "Connected !!");
        return connectWithNoTimeout();
    }