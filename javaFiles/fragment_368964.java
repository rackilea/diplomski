PersistenceDelegate zonedDateTimeDelegate = new PersistenceDelegate() {
    @Override
    protected Expression instantiate(Object target,
                                     Encoder encoder) {
        ZonedDateTime other = (ZonedDateTime) target;
        return new Expression(other, ZonedDateTime.class, "of",
            new Object[] {
                other.getYear(),
                other.getMonthValue(),
                other.getDayOfMonth(),
                other.getHour(),
                other.getMinute(),
                other.getSecond(),
                other.getNano(),
                other.getZone()
            });
    }
};

encoder.setPersistenceDelegate(
    ZonedDateTime.class, zonedDateTimeDelegate);