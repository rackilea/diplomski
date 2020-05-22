static String truncate(String value, int places) {
return new BigDecimal(value)
    .setScale(places, RoundingMode.DOWN)
    .stripTrailingZeros()
    .toString()
}