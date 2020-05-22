public class SO31132861 {
public static void main(String[] args) {
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    df.setLenient(false);

    System.out.println(tryParse(df, "20160630231110"));
    System.out.println(tryParse(df, "20150228231100"));
    System.out.println(tryParse(df, "20160229231100"));

    System.out.println(tryParse(df, "21000229231100")); // 29th Feb on non-leap year 2100
    System.out.println(tryParse(df, "20160631231110")); // 31st Jun invalid day
    System.out.println(tryParse(df, "20160229231160")); // Second > 59
    System.out.println(tryParse(df, "20150229231100")); // 29th Feb on non-leap year 2015
    System.out.println(tryParse(df, "20150228241100")); // Hour > 23

}

private static Boolean tryParse(DateFormat df, String s) {
    Boolean valid=false;
    try {
        Date threeHoursBefore = new Date();
        threeHoursBefore.setTime(System.currentTimeMillis() - (3*60*60*1000));

        Date threeHoursAfter = new Date();
        threeHoursAfter.setTime(System.currentTimeMillis() + (3*60*60*1000));

        Date dateToParse= df.parse(s);

        valid=dateToParse.compareTo(threeHoursBefore) > 0 && dateToParse.compareTo(threeHoursAfter) < 0;
    } catch (ParseException e) {
         valid=false;
    }
    return valid;
}
}