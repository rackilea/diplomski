public class ThreadPoolExecutorHelper {
        private static final String TAG = ThreadPoolExecutorHelper.class.getSimpleName() + " : ";
        private static final boolean LOG_DEBUG = false;

        private static volatile ThreadPoolExecutorHelper INSTANCE;
        private ThreadPoolExecutor mThreadPoolExecutor;
        private BlockingQueue<Runnable> mBlockingQueue;
        private static final int TASK_QUEUE_SIZE = 12;

        //core size, keeps thread : along with running + idle
        private static final int CORE_POOL_SIZE = 5;

        // pool size
        private static final int MAX_POOL_SIZE = 5;

        // core pool size exceeds, idle thread will wait for this time before termination.
        private static final long KEEP_ALIVE_TIME = 20L;

        public static ThreadPoolExecutorHelper getInstance() {
            if (LOG_DEBUG) Log.e(TAG, "getInstance: ");
            if (INSTANCE == null) {
                synchronized (ThreadPoolExecutorHelper.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new ThreadPoolExecutorHelper();
                    }
                }
            }
            return INSTANCE;
        }

        private ThreadPoolExecutorHelper() {
            if (LOG_DEBUG) Log.d(TAG, "ctor: ");
            initBlockingQueue();
            initThreadPoolExecutor();
        }

        // submit Runnables
        public void submitRunnable(Runnable task) {
            if (LOG_DEBUG) Log.d(TAG, "submitRunnable: " + task.getClass().getSimpleName());

            //in case, init again, if null.
            initBlockingQueue();
            initThreadPoolExecutor();
            mThreadPoolExecutor.execute(task);
        }

        // shut the threadpool
        public synchronized void shut() {
            if (LOG_DEBUG) Log.d(TAG, "shut: ");
            if (mThreadPoolExecutor != null) {
                mThreadPoolExecutor.shutdown();
                try {
                    mThreadPoolExecutor.awaitTermination(6000L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    if (LOG_DEBUG) Log.w(TAG, "shut: InterruptedException");
                    mThreadPoolExecutor.shutdownNow();
                }
            } else {
                Log.e(TAG, "shut: mThreadPoolExecutor instance NULL");
            }
        }

        //clean up
        public void cleanResources() {
            if (LOG_DEBUG) Log.e(TAG, "cleanResources: ");
            if (INSTANCE != null) {
                if (mThreadPoolExecutor != null) {
                    mThreadPoolExecutor = null;
                }
                if (mBlockingQueue != null) {
                    mBlockingQueue = null;
                }
                nullifyHelper();
            }
        }

        private static void nullifyHelper() {
            if (INSTANCE != null) {
                INSTANCE = null;
            }
        }

        private void initBlockingQueue() {
            if (mBlockingQueue == null) {
                mBlockingQueue = new LinkedBlockingQueue<>(TASK_QUEUE_SIZE);
            }
        }

        private void initThreadPoolExecutor() {
            if (mThreadPoolExecutor == null) {
                mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
                        KEEP_ALIVE_TIME, TimeUnit.SECONDS, mBlockingQueue);
            }
        }
    }