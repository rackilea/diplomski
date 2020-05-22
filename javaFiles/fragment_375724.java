public class ExecutionAttempt {
    private final Task task;
    private int numberOfFailedAttempts = 0;

    public ExecutionAttempt(Task task) { ... }

    public int getNumberOfFailedAttempts() { ... }

    public void countFailedAttempt() {
        numberOfFailedAttempts++;
    }

    ...
}