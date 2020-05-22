public class StatAccumulator {
    public StatRecord result = new StatRecord(0, 0);
    private final List<String> metrics;
    private final List<String> groups;
    private long count;

    public StatAccumulator(List<String> metrics, List<String> groups) {
        this.metrics = metrics;
        this.groups = groups;
    }

    public void containerize(StatRecord other) {
        //logger.info(initial.toString());
        this.result.v1 += other.v1,
        this.result.v2 += other.v2
        this.count++;
    }

    public void combine(StatAccumulator other) {
        result.v1+= other.result.v1;
        result.v2+= other.result.v2;
        this.count += other.count;
        logger.info("Current Combined: "+this.result.v1.toString());
    }
}