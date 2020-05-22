class Task implements Runnable {

    private boolean shouldRun = true;

    public void stop() {
        this.shouldRun = false;
    }

    @Override
    public void run() {
        while (this.shouldRun) {
            try {
                Thread.sleep(1000);
                System.out.println("Doing some work every 1 second ...");
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        }
        System.out.println("Task have been stopped, Bye!");
        Thread.currentThread().interrupt();
    }
}

 public final class Example {

     public static void main(String[] args) {
         Scanner keyboardScanner = new Scanner(System.in);
         try {
             Task task = new Task();
             // run the task on new Thread
             Thread newThread = new Thread(task);
             newThread.start();
         /*
          read lines while it is not empty:
          (line = keyboardScanner.nextLine()) -> assign the input to line
          !(line ...).isEmpty() -> checks that line is not empty
           */
            System.out.println("Give me inputs");
            String line;
            while (!(line = keyboardScanner.nextLine()).isEmpty()) {
                System.out.println("new line read :" + line);
            }
            // when you give an empty line the while will stop then we stop
            // the task
            task.stop();
        } finally {
            // after the piece of code inside the try statement have finished
            keyboardScanner.close();
        }
        System.out.println("Empty line read. Bye!");
    }
}