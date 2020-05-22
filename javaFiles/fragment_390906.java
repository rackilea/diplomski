Instant now = Instant.parse("2018-06-21T08:40:00.00Z");
Instant then = now.minus(9, ChronoUnit.HOURS);
Instant start;
Instant target;
int delta = 1;
if (then.isBefore(now)) {
    start = then;
    target = now;
} else {
    start = now;
    target = then;
    delta = -1;
}
if (!target.truncatedTo(ChronoUnit.DAYS).equals(start.truncatedTo(ChronoUnit.DAYS))) {
    target = target.plus(1, ChronoUnit.DAYS);
}
while (start.isBefore(target)) {
    System.out.println(start);
    start = start.plus(delta, ChronoUnit.DAYS);
}