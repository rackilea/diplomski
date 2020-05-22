public class Lock {
    private boolean isLocked;

    public synchronized void lock() throws InterruptedException {
        isLocked = true;
        while (isLocked) {
            wait();
        }
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

public class MyHandlerThread extends HandlerThread {
    private Handler mHandler;

    public MyHandlerThread() {
        super("MY_HANDLER_THREAD");
        start();
        mHandler = new Handler(getLooper());
    }

    public Handler getHandler() {
        return mHandler;
    }
}

public class RemoteViewsX implements RemoteViewsFactory {
    private MyHandlerThread mHandlerThread;
    ...
}

public void onDataSetChanged() {
    Lock lock = new Lock();
    mHandlerThread.getHandler().post(new Runnable() {
        @Override
        public void run() {
            Realm realm = Realm.getInstance(ctx);
            results = realm.where(Model.class).findAll();
            lock.unlock();
        }
    });
    lock.lock();
}

public RemoteViews getViewAt(int paramInt) {
    Lock lock = new Lock();
    final RemoteViews[] result = {null};
    mHandlerThread.getHandler().post(new Runnable() {
        @Override
        public void run() {
            // You can safely access results here.
            result[0] = new RemoteViews();
            lock.unlock();
        }
    });
    lock.lock();
    return result[0];
}