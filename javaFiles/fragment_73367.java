public class MultiThreadedTaskScheduler  {

      AtomicInteger priorityCounter = new AtomicInteger(-1);
private ExecutorService executorService = Executors.newFixedThreadPool(10);

private PriorityQueue<Task> taskQueue;
private static final PriorityComparator PRIORITY_COMPARATOR = new PriorityComparator();


        public MultiThreadedTaskScheduler(List<Task> tasks){
            this.taskQueue = new PriorityQueue<Task>(tasks.size(), PRIORITY_COMPARATOR);
            this.taskQueue.addAll(tasks);
        }

        public void executeAllByPriority(){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (Task task : taskQueue) {
                        executeMethod(task);
                    }
                }
            });

        }

    private void executeMethod(Task task) {
        if (task.getPriority()  > priorityCounter.get() ){
            task.execute();
            priorityCounter.getAndSet(task.getPriority());
        }

    }



        public void executeAllByPriorityWithUnInterruptableFirst(){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    PriorityQueue<Task> interruptedQueue = new PriorityQueue<Task>(taskQueue.size(),PRIORITY_COMPARATOR);
                    for (Task task : taskQueue) {
                        if (task instanceof Interruptible && ((Interruptible) task).isInterrupted() ){
                            interruptedQueue.add(task);
                        } else {
                            executeMethod(task);
                        }
                    }

                    for (Task task : interruptedQueue ){
                        executeMethod(task);
                    }
                }
            });

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            executorService.shutdown();
        }

}