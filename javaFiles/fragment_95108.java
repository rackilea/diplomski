// called by a philosopher when they wish to eat
public void takeChopsticks(int philosopherNumber) {
    // acquire chopstick[philosopherNumber] and chopstick[(philosopherNumber + 1) mod 5]
    System.out.println("Acquiring chopstick[" + philosopherNumber + "] and chopstick[" + ((philosopherNumber + 1) % 5) + "]");

    lockLock.lock();
    chopstick[philosopherNumber].lock();
    chopstick[(philosopherNumber + 1) % 5].lock();
    lockLock.unlock();

    // eat for a random number of milliseconds
    int eatTime = r.nextInt(MAX_EAT_TIME);
    System.out.println("Philosopher " + philosopherNumber + " is eating for " + eatTime + " milliseconds");
    try {
        Thread.sleep(eatTime);
    } catch (InterruptedException ex) {
        System.out.println("Philosopher " + philosopherNumber + " eatTime sleep was interrupted");
    }

} // end takeChopsticks