LocalTime startTime = LocalTime.of(0, 0);
LocalTime endTime = LocalTime.of(11, 51);
long span = Duration.between(startTime, endTime).toNanos();

final int n = 23; // Number of pieces
LongStream.rangeClosed(0, n)
    .map(i -> i * span / n)
    .mapToObj(i -> startTime.plusNanos(i))
    .forEach(System.out::println);