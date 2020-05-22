public class Job {
    private static long nextId = 0L;

    private final long id;
    private final int difficulty;
    private final String owner;

    public Job(int difficulty, String owner) {
        this.id = nextId++;
        this.difficulty = difficulty;
        this.owner = owner;
    }

    // ...
}