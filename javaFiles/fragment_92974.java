@Override
public void scheduleHeavyTask(IServCallback callback)
        throws RemoteException {
    servCallback = callback;
    Runnable task = new Runnable(){

        @Override
        public void run() {
            result = doSomethingLong();
            try {
                Log.d(TAG, "Sending result!");
                servCallback.onResult(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    };
    new Thread(task).start();
}