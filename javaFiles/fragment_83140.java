DetachedCriteria criteria = DetachedCriteria.forClass(Contract.class)
    .add(Restrictions.le("startDate", toEndOfYear(year))
    .add(Restrictions.ge("endDate", toStartOfYear(year)));

public Date toStartOfYear(int year) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.DAY_OF_YEAR, 0);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTime();
}

public Date toEndOfYear(int year) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.DAY_OF_YEAR, 0);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND,-1);
    return calendar.getTime();
}