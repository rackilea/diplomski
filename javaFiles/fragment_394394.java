@Override
public synchronized void run() {
    while (yourFinishCondition && !Thread.interrupted()) {
        // do stuff until you finish, or until the thread is interrupted from the outside
    }
}