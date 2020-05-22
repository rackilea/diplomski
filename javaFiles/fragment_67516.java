public class Main {
    public static int getDifferenceDays(Date d1, Date d2) {
        int daysdiff=0;
        long diff = d2.getTime() - d1.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000)+1;
        daysdiff = (int) diffDays;
        return daysdiff;
    }

    public static void main(String[] args) throws ParseException {
        String dateStart = "11/21/2016";
        String dateStop =  "11/22/2016";

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        Date d1 = format.parse(dateStart);
        Date d2 = format.parse(dateStop);

        System.out.println(getDifferenceDays(d1,d2));
    }
}