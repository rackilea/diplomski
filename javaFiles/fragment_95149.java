ZoneId londonTimezone = ZoneId.of("Europe/London");
ZoneRules rules = londonTimezone.getRules();

// get all the transitions (dates when the offset changes)
rules.getTransitions().forEach(t -> {
    // UTC instant when the change occurs
    Instant instant = t.getInstant();

    // local date/time before the transition
    LocalDateTime before = t.getDateTimeBefore();
    // UTC offset before the transition
    ZoneOffset offsetBefore = t.getOffsetBefore();

    // local date/time after the transition
    LocalDateTime after = t.getDateTimeAfter();
    // UTC offset afger the transition
    ZoneOffset offsetAfter = t.getOffsetAfter();

    // is GAP (clock shifts forward - local times are skipped)
    boolean gap = t.isGap();
    // is overlap (clock shifts backwards - local times can happen twice) 
    boolean overlap = t.isOverlap();

    // *** You can use the data above to check if the transition date matches your list***
});