public class IdGenerator {
    private SecureRandom random = new SecureRandom();   
    private long preservedMask;
    private long randomMask;

    public void init(int preservedBits) {
        this.preservedMask = (1L << preservedBits) - 1;
        this.randomMask = ~this.preservedMask;
    }

    public long makeIdFrom(long preserved) {
        return (this.random.nextLong() & this.randomMask) | (preserved & this.preservedMask);
    }

    public UUID makeUuidFrom(long preserved) {
        UUID uuid = UUID.randomUUID();
        return new UUID(uuid.getMostSignificantBits(), (uuid.getLeastSignificantBits() & this.randomMask) | (preserved & this.preservedMask));
    }

    public boolean idsMatch(long id1, long id2) {
        return (id1 & this.preservedMask) == (id2 & this.preservedMask);
    }
}