List<Date> dates = new ArrayList<>();
Date start = new Date();
while (start.before(end)) {
    start = cron.next(start);
    dates.add(start);
}