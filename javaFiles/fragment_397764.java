public class Job {
    private static AtomicLong nextId = new AtomicLong();

    private final long id;
    private final int difficulty;
    private final String owner;

    public Job(int difficulty, String owner) {
        this.id = nextId.getAndIncrement();
        this.difficulty = difficulty;
        this.owner = owner;
    }

    // ...
}