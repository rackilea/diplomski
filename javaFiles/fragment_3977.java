public static void main (String[] args) throws Exception {
  Worker worker = new WorkerImpl(/* whatever args are needed */);
  Thread workerThread = new Thread(worker);
  System.out.println("Starting process...");

  worker.start();
  Scanner sc = new Scanner(System.in);

  while(true) {
    System.out.printn("Please enter command: ");
    String command = sc.nextLine();
    if("END".equals(command)) {
      System.out.println("Terminating program... ");
      workerThread.interrupt();
      break;
    } else if ("GO".equals(command)) {
      synchronized(worker.getLock()) {
        System.out.println("Continuing worker thread... ");
        worker.enable();
        worker.getLock().notifyAll();
      }
    } else if ("STOP".equals(command)) {
      synchronized(worker.getLock()) {
        System.out.println("Stopping worker thread ");
        worker.disable();
        worker.getLock().notifyAll();
      }
    } else {
      printCommandHelp();
    }
  }
};