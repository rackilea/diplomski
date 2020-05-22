public static int K = 5;
    public static int N = 10;

    final static Lock lock = new ReentrantLock(true);
    final static Condition toStart = lock.newCondition();
    final static Condition toLand = lock.newCondition();
    static int wantsToStart = 0;
    static int wantsToLand = 0;
    static int atAirport = 0;
    static boolean free = true;

    private static void free_landing_area() {
        if (atAirport < K) {
            if (wantsToLand > 0) {
                toLand.signal();
            } else {
                toStart.signal();
            }
        } else {
            if (wantsToStart > 0) {
                toStart.signal();
            } else if (atAirport < N) {
                toLand.signal();
            }
        }
    }

    public static void wants_to_start() {
        lock.lock();
        if (!free) {
            try {
                wantsToStart++;
                toStart.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        free = false;
        lock.unlock();
    }

    public static void started() {
        lock.lock();
        atAirport -= 1;
        free = true;
        wantsToStart--;
        free_landing_area();
        lock.unlock();
    }

    public static void wants_to_land() {
        lock.lock();
        if (!free || atAirport == N) {
            try {
                wantsToLand++;
                toLand.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        free = false;
        lock.unlock();
    }

    public static void landed() {
        lock.lock();
        atAirport += 1;
        free = true;
        wantsToLand--;
        free_landing_area();
        lock.unlock();
    }