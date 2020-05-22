public static List<DateBucket> bucketize(ZonedDateTime fromDate, ZonedDateTime toDate, int bucketSize, ChronoUnit bucketSizeUnit) {
    return LongStream.rangeClosed(0, bucketSizeUnit.between(fromDate, toDate))
            .mapToObj(i -> {
                ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
                ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
                return new DateBucket(minDate.toInstant(), maxDate.toInstant());
            })
            .filter(b -> {
                ZonedDateTime maxDate = b.getMaxDate().atZone(toDate.getZone());
                ZonedDateTime limitDate = toDate.plus(bucketSize, bucketSizeUnit);
                return maxDate.isBefore(limitDate) || maxDate.isEqual(limitDate);
            })
            .collect(Collectors.toList());
}