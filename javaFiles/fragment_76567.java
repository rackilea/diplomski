public class Archer {
    private Random random = new Random();
    public final double chance;
    public Archer(double chance) {
        this.chance = chance;
    }
    public boolean shoot() {
        return random.nextDouble() < chance;
    }
}

// ...

public boolean sample_problem2() {
    for (Archer archer : archers) {
        if (archer.shoot()) return true;
    }
    return false;
}

public double estimate_sample2(long count) {
    long positive = 0;
    for (long i = 0; i < count; i++) {
        if (sample_problem2()) positive++;
    }
    return (double)positive / (double)count;
}