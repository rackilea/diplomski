public class BoundedOutOfOrdernessGenerator implements AssignerWithPeriodicWatermarks<Event> {

    private static final long serialVersionUID = 1L;

    /** The current maximum timestamp seen so far. */
    private long currentMaxTimestamp;

    /** The timestamp of the last emitted watermark. */
    private long lastEmittedWatermark = Long.MIN_VALUE;

    /**
     * The (fixed) interval between the maximum seen timestamp seen in the records
     * and that of the watermark to be emitted.
     */
    private final long maxOutOfOrderness;

    public BoundedOutOfOrdernessGenerator() {
        Time maxOutOfOrderness = Time.seconds(5);

        if (maxOutOfOrderness.toMilliseconds() < 0) {
            throw new RuntimeException("Tried to set the maximum allowed " + "lateness to " + maxOutOfOrderness
                    + ". This parameter cannot be negative.");
        }
        this.maxOutOfOrderness = maxOutOfOrderness.toMilliseconds();
        this.currentMaxTimestamp = Long.MIN_VALUE + this.maxOutOfOrderness;
    }

    public long getMaxOutOfOrdernessInMillis() {
        return maxOutOfOrderness;
    }

    /**
     * Extracts the timestamp from the given element.
     *
     * @param element The element that the timestamp is extracted from.
     * @return The new timestamp.
     */
    public long extractTimestamp(Event element) {
        long timestamp = element.getOccurrenceTimeStamp();
        return timestamp;
    }

    @Override
    public final Watermark getCurrentWatermark() {
        Instant instant = Instant.now();
        long nowTimestampMillis = instant.toEpochMilli();
        long latenessTimestamp = nowTimestampMillis - maxOutOfOrderness;

        if (latenessTimestamp >= currentMaxTimestamp) {
            currentMaxTimestamp = latenessTimestamp;
        }

        // this guarantees that the watermark never goes backwards.
        long potentialWM = currentMaxTimestamp - maxOutOfOrderness;
        if (potentialWM >= lastEmittedWatermark) {
            lastEmittedWatermark = potentialWM;
        }
        return new Watermark(lastEmittedWatermark);
    }

    @Override
    public final long extractTimestamp(Event element, long previousElementTimestamp) {
        long timestamp = extractTimestamp(element);
        if (timestamp > currentMaxTimestamp) {
            currentMaxTimestamp = timestamp;
        }
        return timestamp;
    }
}