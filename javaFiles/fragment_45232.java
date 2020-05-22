public class Test {
    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("H:mm");
        Date myDate = df.parse("17:45");
        System.out.println(myDate.toString());

        Calendar c = Calendar.getInstance();
        c.setTime(myDate);

        int hours = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        System.out.println("Hour = " + hours + "\nMin = " + min);
    }
}