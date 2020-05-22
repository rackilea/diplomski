public class DateExample {

    public static void main(String[] args) {
        System.out.println(isWithin("2014-01-01", -7));
        System.out.println(isWithin("2014-01-03", -7));
        System.out.println(isWithin("2013-12-27", -7));
    }

    public static boolean isWithin(String date, int days){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateProvided = null;
        try {
            dateProvided = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } 

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.set(Calendar.HOUR, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date comparisonDate = calendar.getTime();

        return comparisonDate.equals(dateProvided);
    }
}