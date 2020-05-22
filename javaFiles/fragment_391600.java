public class DateTimeRange {

    private final ZonedDateTime from;
    private final ZonedDateTime to;

    DateTimeRange(ZonedDateTime from, ZonedDateTime to) {
        this.from = from;
        this.to = to;
    }

    public static DateTimeRange of(LocalDateTime from, LocalDateTime to, ZoneId zoneId) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        Objects.requireNonNull(zoneId);

        return new DateTimeRange(ZonedDateTime.of(from, zoneId), ZonedDateTime.of(to, zoneId));
    }
    public Stream<ZonedDateTime> streamOn(ChronoUnit unit) {
        Objects.requireNonNull(unit);

        ZonedDateTimeSpliterator zonedDateTimeSpliterator = new ZonedDateTimeSpliterator(from, to, unit);
        return StreamSupport.stream(zonedDateTimeSpliterator, false);
    }

    static class ZonedDateTimeSpliterator implements Spliterator<ZonedDateTime> {

        private final ChronoUnit unit;

        private ZonedDateTime current;
        private ZonedDateTime to;

        ZonedDateTimeSpliterator(ZonedDateTime from, ZonedDateTime to, ChronoUnit unit) {
            this.current = from.truncatedTo(unit);
            this.to = to.truncatedTo(unit);
            this.unit = unit;
        }

        @Override
        public boolean tryAdvance(Consumer<? super ZonedDateTime> action) {
            boolean canAdvance = current.isBefore(to);

            if (canAdvance) {
                action.accept(current);
                current = current.plus(1, unit);
            }

            return canAdvance;
        }

        @Override
        public Spliterator<ZonedDateTime> trySplit() {
            long halfSize = estimateSize() / 2;
            if (halfSize == 0) {
                return null;
            }

            ZonedDateTime splittedFrom = current.plus(halfSize, unit);
            ZonedDateTime splittedTo = to;
            to = splittedFrom;

            return new ZonedDateTimeSpliterator(splittedFrom, splittedTo, unit);
        }

        @Override
        public long estimateSize() {
            return unit.between(current, to);
        }

        @Override
        public Comparator<? super ZonedDateTime> getComparator() {
            // sorted in natural order
            return null;
        }

        @Override
        public int characteristics() {
            return Spliterator.NONNULL | Spliterator.IMMUTABLE | Spliterator.SIZED | Spliterator.SUBSIZED | Spliterator.ORDERED | Spliterator.SORTED | Spliterator.DISTINCT;
        }

    }

}