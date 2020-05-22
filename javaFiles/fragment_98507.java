public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
public static void main(String args[]) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2009-12-31");
    Date date2 = sdf.parse("2010-01-31");

    boolean moreThanDay = Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY;

    System.out.println(moreThanDay);
}