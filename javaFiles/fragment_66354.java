Set<DayOfWeek> invalidDays = EnumSet.of(DayOfWeek.SUNDAY);

@Override
public boolean isInvalid(Date date) {
    // First convert to a modern type
    ZonedDateTime zdt = date.toInstant().atZone(ZoneId.systemDefault());
    DayOfWeek dow = zdt.getDayOfWeek();
    return invalidDays.contains(dow);
}