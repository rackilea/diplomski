LocalDateTime now = LocalDateTime.parse("2018-06-21T08:40:00.00Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
LocalDateTime then = now.minusHours(7);
LocalDate start;
LocalDate target;
int delta = 1;
if (then.isBefore(now)) {
    start = then.toLocalDate();
    target = now.toLocalDate();
    delta = 1;
} else {
    start = now.toLocalDate();
    target = then.toLocalDate();
    delta = -1;
}
target = target.plusDays(1);
while (start.isBefore(target)) {
    System.out.println(start);
    start = start.plusDays(delta);
}