private static class ThisLocalizedWeek {

    // Try and always specify the time zone you're working with
    private final static ZoneId TZ = ZoneId.of("Pacific/Auckland");

    private final Locale locale;
    private final DayOfWeek firstDayOfWeek;
    private final DayOfWeek lastDayOfWeek;

    public ThisLocalizedWeek(final Locale locale) {
        this.locale = locale;
        this.firstDayOfWeek = WeekFields.of(locale).getFirstDayOfWeek();
        this.lastDayOfWeek = DayOfWeek.of(((this.firstDayOfWeek.getValue() + 5) % DayOfWeek.values().length) + 1);
    }

    public LocalDate getFirstDay() {
        return LocalDate.now(TZ).with(TemporalAdjusters.previousOrSame(this.firstDayOfWeek));
    }

    public LocalDate getLastDay() {
        return LocalDate.now(TZ).with(TemporalAdjusters.nextOrSame(this.lastDayOfWeek));
    }

    @Override
    public String toString() {
        return String.format(   "The %s week starts on %s and ends on %s",
                                this.locale.getDisplayName(),
                                this.firstDayOfWeek,
                                this.lastDayOfWeek);
    }
}