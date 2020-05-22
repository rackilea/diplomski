mThread.start();
try {
    mThread.join();
} catch (InterruptedException i) {
    i.printStackTrace();

}