public class MySpliterator implements Spliterator<String> {
    private long position;
    private String currentPermutation;
    private final long limit;

    MySpliterator(long position, long limit, String currentPermutation) {
        this.position = position;
        this.limit = limit;
        this.currentPermutation = currentPermutation;
    }

    @Override
    public Spliterator<String> trySplit() {
        if(limit - position <= 1)
            return null;
        long newPosition = (position+limit)>>>1;
        Spliterator<String> prefix = 
                 new MySpliterator(position, newPosition, currentPermutation);
        this.position = newPosition;
        this.currentPermutation = calculatePermutation(newPosition); // hard part
        return prefix;
    }

    ...
}