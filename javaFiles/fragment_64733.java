public static void main(String[] args) {
     //creates a executor service with a fixed number of threads
     //that this ExecutorService can access
    ExecutorService executor = Executors.newFixedThreadPool(10);
    //submitting a callable runs it asynchronously, executor returns
    //a Future object we can use later to get the returned value
    //once the callable is done executing.
    Future<Integer> userInput = executor.submit(new BilSpil());
    int commands = 0; 

    ...

    while (gameIsLive) { 
        if(userInput.isDone()){
            try {
                commands = userInput.get().intValue();
            } catch (InterruptedException ex) {
              commands = 0;
            } catch (ExecutionException ex) {
               commands = 0;
            }
            userInput = executor.submit(new BilSpil());
        }

        switch(commands){
            case 2:
                y += 10;
                break;
            case 4:
                x -= 10;
                break;
            case 8:
                y -= 10;
                break;
            case 6:
                x += 10;
                break;
        }
        cp.paintOval(x, y, 5, 5);
        cp.repaintFrame();
    }

}