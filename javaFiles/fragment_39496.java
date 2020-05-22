Scanner scan = new Scanner(System.in);
// The lock used to used to synchronize my threads
Lock lock = new ReentrantLock();
// The target condition
Condition answered = lock.newCondition();
Thread thread2 = new Thread(() -> {
    try {
        // Indicates whether the question has been answered
        boolean hasAnswered = false;
        lock.lock();
        try {
            // Loop until the question has been answered or 10 seconds
            for (int seconds = 10; !hasAnswered && seconds >= 0; seconds--){
                System.out.printf("You have %d sec's left!%n", seconds);
                // Wait 1 second and if await returns true it means that
                // I had an answer in time otherwise it means that we
                // reached the timeout without getting answer
                hasAnswered = answered.await(1L, TimeUnit.SECONDS);
            }
        } finally {
            lock.unlock();
        }
        // Print the message indication whether we get the answer in time or not
        if (hasAnswered) {
            System.out.println("Good Job !!");
        } else {
            System.out.println("Too late !!");
        }
    } catch(InterruptedException e){
        Thread.currentThread().interrupt();
    }
});
System.out.println("What is 1+1? ");
System.out.println("a. 1\t b.2\t c.3\t d.4");
thread2.start();
String answer = scan.next();
lock.lock();
try {
    // Notify the other thread that we have an answer
    answered.signalAll(); // could be answered.signal() as we have only 
                          // thread waiting to be notified but it is a 
                          // better practice to use signalAll
} finally {
    lock.unlock();
}