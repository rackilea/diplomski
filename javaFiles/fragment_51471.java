public static Specification<Transit>compareTimestamps(Timestamp timestamp){
    LocalTime localTime = timestamp.toLocalDateTime().toLocalTime();
    LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
    Specification<Transit> dateSpec = compareDateWithTimestamp(localDate);
    Specification<Transit> dateTimeSpec = compareDateAndTimeWithTimestamp(localDate, localTime);
    return where(dateSpec).or(dateTimeSpec);
}

private static <T>Specification<T> compareDateWithTimestamp(LocalDate localDate){
    return (Specification<T>) (root,query,cb) -> cb.greaterThan(root.get("dTrn"),localDate);
}
private static <T>Specification<T> compareDateAndTimeWithTimestamp(LocalDate localDate, LocalTime localTime){
    return (Specification<T>) (root, query, cb) -> {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("dTrn"),localDate));
        predicates.add(cb.greaterThanOrEqualTo(root.get("dTimTrn"),localTime));
        return cb.and(predicates.toArray(new Predicate[]{}));
    };
}