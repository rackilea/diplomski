ExecutorService executor = ...

int groupThreadLimit = 3;
final BlockingQueue<Runnable> groupTaskQueue = ...;

// Add all your tasks to the groupTaskQueue.

for(int i = 0; i < groupThreadLimit; i++) {
    executor.execute(new Runnable() {
        public void run() {
            while(true) {
                Runnable r = groupTaskQueue.pollFirst();
                if(r == null) {
                    return; // All tasks complete or being processed. Queue empty.
                }
                r.run();
            }
        }
    });
}