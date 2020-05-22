TreeSet<PositionReport> toTreeSet(Collection<PositionReport> reports, long timestamp) {
    return reports().stream().filter(report -> report.getTimestamp() >= timestamp).collect(
        Collectors.toCollection(
            () -> new TreeSet<>(
                Comparator.comparingLong(PositionReport::getTimestamp)
            )
        )
    );
}