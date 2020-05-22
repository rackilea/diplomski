class FairServer {

    private final int maxActiveRequests;
    private final int maxWaitingRequests;
    private final int minActiveRequestPerUser;
    private final int maxActiveRequestsPerUser;
    private final AtomicInteger currentTotalActiveRequests;
    private final Map<Integer, AtomicInteger> currentActiveRequestsPerUser;
    private final BlockingQueue<UserRequest> waitingQueue;
    private final ThreadPoolExecutor threadPoolExecutor;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Lock lock;
    private AtomicInteger currentLimitPerUser;

    public FairServer(int maxActiveRequests, int maxWaitingRequests, int minActiveRequestPerUser, int maxActiveRequestsPerUser) {
        this.maxActiveRequests = maxActiveRequests;
        this.maxWaitingRequests = maxWaitingRequests;
        this.minActiveRequestPerUser = minActiveRequestPerUser;
        this.maxActiveRequestsPerUser = maxActiveRequestsPerUser;
        this.currentLimitPerUser = new AtomicInteger(0);
        this.currentTotalActiveRequests = new AtomicInteger(0);
        this.currentActiveRequestsPerUser = new HashMap<Integer, AtomicInteger>();
        this.waitingQueue = new PriorityBlockingQueue<UserRequest>(maxWaitingRequests, new UserRequestComparator());
        this.lock = new ReentrantLock();
        this.threadPoolExecutor = new LocalThreadPoolExecutor(0, maxActiveRequests, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.scheduledExecutorService.scheduleWithFixedDelay(new FairnessManager(), 1L, 1L, TimeUnit.SECONDS);
    }

    public void submitUserRequest(UserRequest userRequest) {
        if (waitingQueue.size() >= maxWaitingRequests) {
            throw new RuntimeException("Max limit reached");
        }
        if (currentTotalActiveRequests.get() < maxActiveRequests) {
            lock.lock();
            try {
                int currentLimit = Math.round(maxActiveRequests / (currentActiveRequestsPerUser.size() == 0 ? 1 : currentActiveRequestsPerUser.size()));
                currentLimitPerUser.set(currentLimit < minActiveRequestPerUser ? minActiveRequestPerUser : (currentLimit > maxActiveRequestsPerUser ? maxActiveRequestsPerUser : currentLimit));
                trySubmit(userRequest);
            } finally {
                lock.unlock();
            }
        } else {
            // add request to waiting queue and let FairnessManager handle it
            waitingQueue.add(userRequest);
        }

    }

    private void trySubmit(UserRequest userRequest) {
        // directly submit to thread pool executor if less load overall and per user
        AtomicInteger counter = currentActiveRequestsPerUser.get(userRequest.getUserId());
        if (currentTotalActiveRequests.get() < maxActiveRequests && (counter == null || counter.get() < currentLimitPerUser.get())) {
            currentTotalActiveRequests.incrementAndGet();
            if (counter == null) {
                currentActiveRequestsPerUser.put(userRequest.getUserId(), (counter = new AtomicInteger(0)));
            }
            counter.incrementAndGet();
            threadPoolExecutor.submit(userRequest);
        } else {
            // add request to waiting queue and let FairnessManager handle it
            waitingQueue.add(userRequest);
        }
    }

    private class UserRequestComparator implements Comparator<UserRequest> {
        @Override
        public int compare(UserRequest o1, UserRequest o2) {
            AtomicInteger count1 = currentActiveRequestsPerUser.get(o1.getUserId());
            AtomicInteger count2 = currentActiveRequestsPerUser.get(o2.getUserId());
            if (count1 == null) { // this means no current requests by this user
                return -1;
            } else if (count2 == null) { // this means no current requests by this user
                return 1;
            } else {
                return count1.get() <= count2.get() ? -1 : 1; // user with less current requests goes up in the queue
            }
        }
    }

    private class FairnessManager implements Runnable {
        public void run() {
            if (!waitingQueue.isEmpty() && currentTotalActiveRequests.get() < maxActiveRequests) {
                lock.lock();
                try {
                    int maxIterations = 5; // just to avoid endless attempts
                    UserRequest userRequest;
                    while (maxIterations-- > 0 && (userRequest = waitingQueue.poll()) != null) {
                        trySubmit(userRequest);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class LocalThreadPoolExecutor extends ThreadPoolExecutor {
        public LocalThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            if (r instanceof UserRequest) {
                currentTotalActiveRequests.decrementAndGet();
                int userId = ((UserRequest) r).getUserId();
                lock.lock();
                try {
                    int count = currentActiveRequestsPerUser.get(userId).decrementAndGet();
                    if (count == 0) {
                        currentActiveRequestsPerUser.remove(userId);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}