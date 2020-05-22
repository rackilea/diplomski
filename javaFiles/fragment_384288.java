public static long toBytes(String filesize) {
    long returnValue = -1;
    Pattern patt = Pattern.compile("([\\d.]+)([GMK]B)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = patt.matcher(filesize);
    Map<String, Integer> powerMap = new HashMap<String, Integer>();
    powerMap.put("GB", 3);
    powerMap.put("MB", 2);
    powerMap.put("KB", 1);
    if (matcher.find()) {
      String number = matcher.group(1);
      int pow = powerMap.get(matcher.group(2).toUpperCase());
      BigDecimal bytes = new BigDecimal(number);
      bytes = bytes.multiply(BigDecimal.valueOf(1024).pow(pow));
      returnValue = bytes.longValue();
    }
    return returnValue;
}