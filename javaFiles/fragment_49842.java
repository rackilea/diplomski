Specification<Event> predicate = (root, query, cb) -> {

    Expression<Time> currentTime = cb.currentTime();

    return cb.and(
        cb.equal(root.get("start"), cb.currentDate()), // if start date == current date
        cb.lessThan( // if period < current hour * 60 + current minutes
            root.get("period"), 
            cb.sum( // current hour * 60 + current minutes
                cb.prod(cb.function("hour", Integer.class, currentTime), 60), // hours * 60
                cb.function("minute", Integer.class, currentTime) // current minutes
            )
        )
    );
};

List<Event> events = findAll(predicate);