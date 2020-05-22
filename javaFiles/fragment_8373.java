cancellationRules.takeWhile(new Predicate<CancellationRule> {
    private int previousHours = Integer.MAX_VALUE;
    public boolean test(CancellationRule rule) {
        boolean result = rule.hours >= 24 || previousHours >= 24;
        previousHours = rule.hours;
        return result;
    }
});