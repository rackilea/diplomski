public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {
    long diffInMillies = date2.getTime() - date1.getTime();
    List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
    Collections.reverse(units);
    Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
    long milliesRest = diffInMillies;
    for ( TimeUnit unit : units ) {
        long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
        long diffInMilliesForUnit = unit.toMillis(diff);
        milliesRest = milliesRest - diffInMilliesForUnit;
        result.put(unit,diff);
    }
    return result;
}