private AsyncTask<Void, Void, Void> task1 = new AsyncTask<Void, Void, Void>() {
    @Override
    protected Void doInBackground(Void... params) {
        Log.d("Test", "Thread 1");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (task2 != null && task2.getStatus() == Status.FINISHED) {
            task3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }
};

private AsyncTask<Void, Void, Void> task2 = new AsyncTask<Void, Void, Void>() {
    @Override
    protected Void doInBackground(Void... params) {
        // Test the correct asynchronous behavior by sleeping thread 2
        //  try {
        //      Thread.sleep(100);
        //  } catch (InterruptedException e) {
        //      e.printStackTrace();
        //  }
        Log.d("Test", "Thread 2");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (task1 != null && task1.getStatus() == Status.FINISHED) {
            task3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }
};

private AsyncTask<Void, Void, Void> task3 = new AsyncTask<Void, Void, Void>() {
    @Override
    protected Void doInBackground(Void... params) {
        Log.d("Test", "Thread 3");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
};

public void randomMethod(){
    task1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    task2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
}