List<Interval> list = new ArrayList<Interval>();
if (firstInterval.getStart().isBefore(nightToDay)) {
    list.add(new Interval(firstInterval.getStart(), nightToDay));
}
if (nightToDay.isBefore(dayToNight)) {
    list.add(new Interval(nightToDay, dayToNight));
}
if (dayToNight.isBefore(firstInterval.getEnd())) {
    list.add(new Interval(dayToNight, firstInterval.getEnd()));
}