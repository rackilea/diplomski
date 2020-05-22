static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
static final long EPOCH = new Date(2015 - 1900, Calendar.JANUARY, 1).getTime(); // 2015/1/1 in GMT

public static int secondSinceEpoch() {
    return (int) ((System.currentTimeMillis() - EPOCH) / 1000);
}

public static String epochToString(int secsSince2015) {
    return SDF.format(new Date(secsSince2015 * 1000 + EPOCH));
}

public static void main(String... ignored) {
    System.out.println(new Date(EPOCH));
    System.out.println("Epoch is " + epochToString(0));
    System.out.println("Today is " + secondSinceEpoch() + " secs");
    System.out.println("Today is " + secondSinceEpoch() / 86400 + " days");
}