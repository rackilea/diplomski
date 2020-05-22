public class PrimeGenerator {
    private long current = 1;
    private final List<Long> primes = new ArrayList<>();

    public long next() {
        do {
            current++;
        } while (primes.stream().anyMatch(n -> current % n == 0));
        primes.add(current);
        return current;
    }

    public LongStream stream() {
        return LongStream.generate(this::next);
    }
}