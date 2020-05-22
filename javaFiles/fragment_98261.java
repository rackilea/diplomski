class LockingScenario {
    private static final Map<String, Vector<Task>> BUFFER = new ConcurrentHashMap<>();

    public void bufferTransaction(Context ctx) {
        String transaction = ctx.getTransaction();
        Vector<Task> tasks;
        // prevent creation of two Vectors for the same transaction
        synchronized (BUFFER) {
            tasks = BUFFER.get(transaction);
            if (tasks == null) {
                tasks = new Vector<>();
                BUFFER.put(transaction, tasks);
            }
        }
        // create tasks and put into Vector
        tasks.add(createTask());
    }
}