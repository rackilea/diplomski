class Behavior {
    private static AtomicInteger counter = new AtomicInteger(0);

    public Behavior(BehaviorDto behaviorDto) {
        \\other constructor things
        this.id = counter.incrementAndGet();
    }
}