public class MyClass {

    private LinkedBlockingQueue<MyTask> myTaskProcessingQueue;

    public MyClass() {
        myTaskProcessingQueue = new LinkedBlockingQueue<MyTask>();
        new MyTaskWorker().start();
    }

    public void processTask(MyTask myTask) {
        myTaskProcessingQueue.put(myTask);
    }

    private class MyTaskWorker extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    processMyTask(myTaskProcessingQueue.take());
                } catch (InterruptedException ie) {
                    // handle it
                }
            }
        }

        private void processMyTask(MyTask myTask) {
            // do work
        }
    }
}