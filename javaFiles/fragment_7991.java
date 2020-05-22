public static Map<Listing, Long> getDuplicateCount(Collection<Listing> listings) {
    return listings.stream().collect(
        Collectors.groupingBy(e ->
            new Listing(-1, e.getSeller(), e.getItems(), e.getCreatedTime(),
                e.getPrice(), e.isClaimed(), e.isSold(), e.getBuyer(),
                e.getSoldDate(), e.isCanceled()
            ),
            Collector.of(() -> new Object() {
                Listing oneOfThem;
                long count;
            },
            (o, l) -> { o.oneOfThem = l; o.count++; },
            (o1, o2) -> {
                o1.count += o2.count;
                if(o1.oneOfThem == null) o1.oneOfThem = o2.oneOfThem;
                return o1;
            })))
        .values().stream()
        .collect(Collectors.toMap(o -> o.oneOfThem, o -> o.count));
}