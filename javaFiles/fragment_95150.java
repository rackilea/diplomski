rules.getTransitionRules().forEach(rule -> {
    // get a transition for specific year
    ZoneOffsetTransition transition = rule.createTransition(2018);

    // use the transition the same as above (getInstant(), getDateTimeBefore(), etc)
});