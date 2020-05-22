class Timeslot {
  Instant start, end;

  Duration overlap(Timeslot other) {
    long startOverlap = Math.max(this.start.toEpochMilli(), other.start.toEpochMilli());
    long endOverlap = Math.min(this.end.toEpochMilli(), other.end.toEpochMilli());
    if (endOverlap <= startOverlap) return Duration.ofMillis(0); //or a negative duration?
    else return Duration.ofMillis(endOverlap - startOverlap);
  }
}