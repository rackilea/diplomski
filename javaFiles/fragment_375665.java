private final double[] accounts;
private Lock bankLock;
private Condition sufficientFunds;

public void transfer(int from, int to, int amount) {
    bankLock.lock();
    try { 
        while (accounts[from] < amount) {
            sufficientFunds.await();
        }
        // transfer funds ...
        sufficientFunds.signalAll();
    } finally { 
        bankLock.unlock(); 
    }
}

public void deposit(int to, int amount) {
    bankLock.lock();
    try {
        // deposit funds...
        sufficientFunds.signalAll();
    } finally {
        bankLock.unlock();
    }
}