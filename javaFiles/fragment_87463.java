/**
 * If this thread was constructed using a separate
 * Runnable run object, then that
 * Runnable object's run method is called;
 * otherwise, this method does nothing and returns.
 * 
 * Subclasses of Thread should override this method.
 */
public void run() {
    if (target != null) {
        target.run();
    }
}