public static void main(String[] args) {
    Instant instant = Instant.now();
    Duration duration = Duration.ofSeconds(10);
    Instant toCheck = instant.plusSeconds(5);

    Duration d = Duration.between(instant, toCheck);
    if (!d.isNegative() && d.compareTo(duration) <= 0) {
        System.out.println("is in interval!");
    }
}