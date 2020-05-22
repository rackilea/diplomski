public interface Listener {

    public void changed(int oldValue, int newValue);
}

public class Account {

    private int id;
    private int balance;
    protected ReadWriteLock lock = new ReentrantReadWriteLock();
    List<Listener> accountListeners = new ArrayList<>();

    public Account(int id) {
        this.id = id;
        this.balance = 0;
    }

    public int getBalance() {
        int localBalance;
        lock.readLock().lock();
        try {
            localBalance = this.balance;
        } finally {
            lock.readLock().unlock();
        }
        return localBalance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Negative balance");
        }
        // Keep track of the old balance for the listener.
        int oldValue = this.balance;
        lock.writeLock().lock();
        try {
            this.balance = balance;
        } finally {
            lock.writeLock().unlock();
        }
        if (this.balance != oldValue) {
            // Inform all listeners of any change.
            accountListeners.stream().forEach((l) -> {
                l.changed(oldValue, this.balance);
            });
        }
    }

    public boolean lock() throws InterruptedException {
        return lock.writeLock().tryLock(1, TimeUnit.SECONDS);
    }

    public void unlock() {
        lock.writeLock().unlock();
    }

    public void addListener(Listener l) {
        accountListeners.add(l);
    }

    public int getId() {
        return this.id;
    }

}

public class BankingSystem {

    protected List<Account> accounts;

    public boolean transfer(Account from, Account to, int amount) throws InterruptedException {
        if (from.getId() != to.getId()) {
            if (from.lock()) {
                try {
                    if (from.getBalance() < amount) {
                        return false;
                    }
                    if (to.lock()) {
                        try {
                            // We have write locks on both accounts.
                            from.setBalance(from.getBalance() - amount);
                            to.setBalance(to.getBalance() + amount);
                        } finally {
                            to.unlock();
                        }

                    } else {
                        // Not sure what to do - failed to lock the account.
                    }
                } finally {
                    from.unlock();
                }

            } else {
                // Not sure what to do - failed to lock the account.
            }
        }
        return true;
    }

    // Rest of class..
}