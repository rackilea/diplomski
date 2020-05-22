@Override
public void run() {
    try {
        // Do database stuff with obj
    } catch (PeristenceException ex) {
        // Try again
        executor.execute(this);
    }
}