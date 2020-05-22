// it will check for the file in the current directory
File semaphore = new File("abort.semaphore");
semaphore.deleteOnExit();
System.out.println("run until exist: " + semaphore);
while (!semaphore.exists()) {
    System.out.println("Nothing");
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
System.out.println("ABORT!!!!");