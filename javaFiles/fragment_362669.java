public class UserLoginSerializer {
    private Map<String, Counter> pendingCounts = new HashMap<>();

    public boolean login(String username, String password) {
        Counter numPending;
        boolean result;

        synchronized (pendingCounts) {
            numPending = pendingCounts.get(username);
            if (numPending == null) {
                numPending = new Counter(1);
                pendingCounts.put(username, numPending);
            } else {
                numPending.increment();
            }
        }

        try {
            // username-scoped synchronization:
            synchronized (numPending) {
                result = doLogin(username, password);
            }
        } finally {
            synchronized (pendingCounts) {
                if (numPending.decrement() <= 0) {
                    pendingCounts.remove(username);
                }
            }
        }

        return result;
    }

    /** performs the actual login check */
    private boolean doLogin(String username, String password) {
        // ...
    }
}

class Counter {
    private int value;

    public Counter(int i) {
        value = i;
    }

    /** increments this counter and returns the new value */
    public int increment() {
        return ++value;
    }

    /** decrements this counter and returns the new value */
    public int decrement() {
        return --value;
    }
}