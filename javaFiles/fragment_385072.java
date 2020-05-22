public class gregorianCalendar {
    public static void main(String[] args){
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 100); // <------- add should be here
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int weekday = cal.get(Calendar.DAY_OF_WEEK);

        System.out.print("100 days from today, the date will be: " + month);
        System.out.print("/" + dayOfMonth);
        System.out.println("/" + year);
    }
}