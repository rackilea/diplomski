public static TemporalQuery<String> UNIX_STRING = TimeUtils::toStringUnixTime;

private static String toStringUnixTime(TemporalAccessor temporal) {
  Instant i = Instant.from(temporal);
  BigDecimal nanos = BigDecimal.valueOf(i.getNano(), 9);
  BigDecimal seconds = BigDecimal.valueOf(i.getEpochSecond());
  BigDecimal total = seconds.add(nanos);
  DecimalFormat df = new DecimalFormat("#.#########");
  return df.format(total);
}