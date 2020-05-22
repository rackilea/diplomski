Runnable runnable = new Runnable() {
    // Code as before
};
Thread first = new Thread(runnable);
first.start();
... Maybe the first thread dies...
Thread second = new Thread(runnable);
second.start();