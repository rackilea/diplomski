public static long numberOfDays(final long date) throws ParseException {
    final Calendar compare = Calendar.getInstance();
    compare.setTime(new SimpleDateFormat("yyMMdd").parse(String.valueOf(date)));
    final int dstOffset = compare.get(Calendar.DST_OFFSET);
    final long currentTimeMillis = System.currentTimeMillis();
    final long compareTimeInMillis = compare.getTimeInMillis();
    long difference = 0;
    if (currentTimeMillis >= compareTimeInMillis) {
        difference = currentTimeMillis - compareTimeInMillis - dstOffset;
    } else {
        difference = compareTimeInMillis - currentTimeMillis + dstOffset;
    }
    return difference / (24 * 60 * 60 * 1000);
}