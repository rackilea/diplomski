{
    DatePicker dp = new DatePicker();
    Predicate<Date> enableUntilTodayDates = d -> !d.after(new Date());
    configureShowRangeHandler(dp, enableUntilTodayDates);
}

static HandlerRegistration configureShowRangeHandler(DatePicker dp, Predicate<Date> fn) {
    return dp.addShowRangeHandler(ev -> {
        for (Date t = copyDate(ev.getStart()); t.before(ev.getEnd()); addDaysToDate(t, 1)) {
            dp.setTransientEnabledOnDates(fn.test(t), t);
        }
    });
}