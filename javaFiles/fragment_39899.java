@Override
public T call() throws Exception {
    T value = null;
    while (value==null) {   
            try {
                value = mBlockingQueue.poll(50L,TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage(), e);
                break;
            }
    }
    return value;
}